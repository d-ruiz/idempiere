/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.compiere.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.util.KeyNamePair;

/** Generated Interface for AD_TablePartition
 *  @author iDempiere (generated) 
 *  @version Release 12
 */
public interface I_AD_TablePartition 
{

    /** TableName=AD_TablePartition */
    public static final String Table_Name = "AD_TablePartition";

    /** AD_Table_ID=200411 */
    public static final int Table_ID = 200411;

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 4 - System 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(4);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Tenant.
	  * Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Column_ID */
    public static final String COLUMNNAME_AD_Column_ID = "AD_Column_ID";

	/** Set Column.
	  * Column in the table
	  */
	public void setAD_Column_ID (int AD_Column_ID);

	/** Get Column.
	  * Column in the table
	  */
	public int getAD_Column_ID();

	public org.compiere.model.I_AD_Column getAD_Column() throws RuntimeException;

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within tenant
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within tenant
	  */
	public int getAD_Org_ID();

    /** Column name AD_TablePartition_ID */
    public static final String COLUMNNAME_AD_TablePartition_ID = "AD_TablePartition_ID";

	/** Set Table Partition.
	  * Database Table Partition information
	  */
	public void setAD_TablePartition_ID (int AD_TablePartition_ID);

	/** Get Table Partition.
	  * Database Table Partition information
	  */
	public int getAD_TablePartition_ID();

    /** Column name AD_TablePartition_UU */
    public static final String COLUMNNAME_AD_TablePartition_UU = "AD_TablePartition_UU";

	/** Set AD_TablePartition_UU	  */
	public void setAD_TablePartition_UU (String AD_TablePartition_UU);

	/** Get AD_TablePartition_UU	  */
	public String getAD_TablePartition_UU();

    /** Column name AD_Table_ID */
    public static final String COLUMNNAME_AD_Table_ID = "AD_Table_ID";

	/** Set Table.
	  * Database Table information
	  */
	public void setAD_Table_ID (int AD_Table_ID);

	/** Get Table.
	  * Database Table information
	  */
	public int getAD_Table_ID();

	public org.compiere.model.I_AD_Table getAD_Table() throws RuntimeException;

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name ExpressionPartition */
    public static final String COLUMNNAME_ExpressionPartition = "ExpressionPartition";

	/** Set Expression.
	  * SQL clause for partition
	  */
	public void setExpressionPartition (String ExpressionPartition);

	/** Get Expression.
	  * SQL clause for partition
	  */
	public String getExpressionPartition();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name IsPartitionAttached */
    public static final String COLUMNNAME_IsPartitionAttached = "IsPartitionAttached";

	/** Set Attached.
	  * Partition attached to table
	  */
	public void setIsPartitionAttached (boolean IsPartitionAttached);

	/** Get Attached.
	  * Partition attached to table
	  */
	public boolean isPartitionAttached();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name Parent_TablePartition_ID */
    public static final String COLUMNNAME_Parent_TablePartition_ID = "Parent_TablePartition_ID";

	/** Set Parent Partition.
	  * Parent table partition
	  */
	public void setParent_TablePartition_ID (int Parent_TablePartition_ID);

	/** Get Parent Partition.
	  * Parent table partition
	  */
	public int getParent_TablePartition_ID();

	public org.compiere.model.I_AD_TablePartition getParent_TablePartition() throws RuntimeException;

    /** Column name Processing */
    public static final String COLUMNNAME_Processing = "Processing";

	/** Set Process Now	  */
	public void setProcessing (boolean Processing);

	/** Get Process Now	  */
	public boolean isProcessing();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
}
