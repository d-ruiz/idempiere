/***********************************************************************
 * This file is part of iDempiere ERP Open Source                      *
 * http://www.idempiere.org                                            *
 *                                                                     *
 * Copyright (C) Contributors                                          *
 *                                                                     *
 * This program is free software; you can redistribute it and/or       *
 * modify it under the terms of the GNU General Public License         *
 * as published by the Free Software Foundation; either version 2      *
 * of the License, or (at your option) any later version.              *
 *                                                                     *
 * This program is distributed in the hope that it will be useful,     *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of      *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the        *
 * GNU General Public License for more details.                        *
 *                                                                     *
 * You should have received a copy of the GNU General Public License   *
 * along with this program; if not, write to the Free Software         *
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,          *
 * MA 02110-1301, USA.                                                 *
 *                                                                     *
 * Contributors:                                                       *
 * - hengsin                         								   *
 **********************************************************************/
package org.idempiere.test.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Vector;

import org.compiere.grid.CreateFromStatement;
import org.compiere.minigrid.MiniTableImpl;
import org.compiere.model.GridTab;
import org.compiere.model.GridWindow;
import org.compiere.model.MBankStatement;
import org.compiere.model.MBankStatementLine;
import org.compiere.model.MPayment;
import org.compiere.model.MQuery;
import org.compiere.model.SystemIDs;
import org.compiere.process.DocAction;
import org.compiere.process.ProcessInfo;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.TimeUtil;
import org.compiere.wf.MWorkflow;
import org.idempiere.test.AbstractTestCase;
import org.idempiere.test.DictionaryIDs;
import org.junit.jupiter.api.Test;

/**
 * @author hengsin
 *
 */
public class CreateFromStatementFormTest extends AbstractTestCase {

	/**
	 * default constructor
	 */
	public CreateFromStatementFormTest() {
	}

	@Test
	public void testCreateFromPayments() {
		MPayment payment = new MPayment(Env.getCtx(), 0, getTrxName());
		payment.setC_DocType_ID(true);
		payment.setC_BPartner_ID(DictionaryIDs.C_BPartner.JOE_BLOCK.id);
		payment.setTenderType(MPayment.TENDERTYPE_DirectDebit);
		int C_BankAccount_ID = DB.getSQLValueEx(getTrxName(), "SELECT C_BankAccount_ID FROM C_BankAccount WHERE IsActive='Y' AND AD_Client_ID=? "
				+ "AND IsDefault='Y' ORDER BY C_BankAccount_ID", getAD_Client_ID());
		payment.setC_BankAccount_ID(C_BankAccount_ID);
		int C_Currency_ID = Env.getContextAsInt(Env.getCtx(), Env.C_CURRENCY_ID);
		payment.setC_Currency_ID(C_Currency_ID);
		payment.setPayAmt(new BigDecimal("10.00"));
		payment.saveEx();

		ProcessInfo pi = MWorkflow.runDocumentActionWorkflow(payment, DocAction.ACTION_Complete);
		assertFalse(pi.isError(), pi.getSummary());
		payment.load(getTrxName());
		assertEquals(DocAction.STATUS_Completed, payment.getDocStatus(), "Unexpected document status");
		
		Timestamp today = TimeUtil.getDay(System.currentTimeMillis());
		MBankStatement stmt = new MBankStatement(Env.getCtx(), 0, getTrxName());
		stmt.setC_BankAccount_ID(C_BankAccount_ID);
		stmt.setDateAcct(today);
		stmt.setName("testCreateFromPayments");
		stmt.setStatementDate(today);
		stmt.saveEx();
		
		GridWindow gridWindow = GridWindow.get(Env.getCtx(), 1, SystemIDs.WINDOW_BANK_STATEMENT);
		assertNotNull(gridWindow, "Failed to load grid window of Bank Statement");
		gridWindow.initTab(0);
		GridTab gridTab = gridWindow.getTab(0);
		MQuery query = new MQuery(MBankStatement.Table_Name);
		query.addRestriction(MBankStatement.COLUMNNAME_C_BankStatement_ID, "=", stmt.get_ID());
		gridTab.setQuery(query);
		gridTab.getTableModel().setImportingMode(false, getTrxName());
		gridTab.query(false);
		
		assertEquals(1, gridTab.getRowCount(), "Unexpected number of row retrieve from DB");
		assertEquals(stmt.get_ID(), gridTab.getRecord_ID(), "Wrong Bank Statement record id");
		
		CreateFromStatementImpl form = new CreateFromStatementImpl(gridTab);
		form.setTrxName(getTrxName());
		
		Timestamp dateFrom = TimeUtil.addDays(today, -1);
		Timestamp dateTo = TimeUtil.addDays(today, 1);
		form.loadPayments(C_BankAccount_ID, null, null, dateFrom, dateTo, null, null, payment.getC_DocType_ID(), null, null, C_Currency_ID);
		assertTrue(form.minitable.getRowCount() > 0, "Failed to load data from DB");
		
		form.minitable.setSelectedRow(-1);
		for (int i = 0; i < form.minitable.getRowCount(); i++) {
			KeyNamePair pp = (KeyNamePair) form.minitable.getValueAt(i, 2);
			if (pp.getKey() == payment.get_ID()) {
				form.minitable.setValueAt(Boolean.TRUE, i, 0);
				form.minitable.setSelectedRow(i);
				break;
			}
		}
		
		assertTrue(form.minitable.getSelectedRow() >= 0, "Failed to find payment record");
		assertTrue(form.save(form.minitable, getTrxName()), "Failed to save changes");
		
		stmt.load(getTrxName());
		MBankStatementLine[] lines = stmt.getLines(true);
		assertNotNull(lines, "Null bank statement line");
		assertEquals(1, lines.length, "Unexpected number of bank statement line records");
		assertEquals(payment.get_ID(), lines[0].getC_Payment_ID());
	}
	
	private static class CreateFromStatementImpl extends CreateFromStatement {

		private MiniTableImpl minitable = null;
		
		public CreateFromStatementImpl(GridTab mTab) {
			super(mTab);
			
			try {
				dynInit();
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}

		@Override
		public Object getWindow() {
			return null;
		}
		
		@Override
		protected boolean dynInit() throws Exception {
			super.dynInit();
			minitable = new MiniTableImpl();
			for(String column : getOISColumnNames()) {
				minitable.addColumn(column);
			}
			configureMiniTable(minitable);
			return true;
		}
		
		public void loadPayments(Integer BankAccount, Integer BPartner, String DocumentNo,
				Timestamp DateFrom, Timestamp DateTo, BigDecimal AmtFrom, BigDecimal AmtTo, Integer DocType,
				String TenderType, String AuthCode, Integer C_Currency_ID) {
			Vector<Vector<Object>> datas = super.getBankAccountData(BankAccount, BPartner, DocumentNo, DateFrom, DateTo, AmtFrom, AmtTo, DocType,
					TenderType, AuthCode, C_Currency_ID);
			
			for(int i = 0; i < datas.size(); i++) {
				minitable.setRowCount(i+1);
				Vector<Object> data = datas.get(i);
				for(int j = 0; j < data.size(); j++) {
					minitable.setValueAt(data.get(j), i, j);
				}
			}
		}
	}
}
