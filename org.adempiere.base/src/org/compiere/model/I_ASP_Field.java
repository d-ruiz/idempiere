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

/** Generated Interface for ASP_Field
 *  @author iDempiere (generated) 
 *  @version Release 12
 */
public interface I_ASP_Field 
{

    /** TableName=ASP_Field */
    public static final String Table_Name = "ASP_Field";

    /** AD_Table_ID=53048 */
    public static final int Table_ID = 53048;

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

    /** Column name AD_Field_ID */
    public static final String COLUMNNAME_AD_Field_ID = "AD_Field_ID";

	/** Set Field.
	  * Field on a database table
	  */
	public void setAD_Field_ID (int AD_Field_ID);

	/** Get Field.
	  * Field on a database table
	  */
	public int getAD_Field_ID();

	public org.compiere.model.I_AD_Field getAD_Field() throws RuntimeException;

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

    /** Column name ASP_Field_ID */
    public static final String COLUMNNAME_ASP_Field_ID = "ASP_Field_ID";

	/** Set ASP Field	  */
	public void setASP_Field_ID (int ASP_Field_ID);

	/** Get ASP Field	  */
	public int getASP_Field_ID();

    /** Column name ASP_Field_UU */
    public static final String COLUMNNAME_ASP_Field_UU = "ASP_Field_UU";

	/** Set ASP_Field_UU	  */
	public void setASP_Field_UU (String ASP_Field_UU);

	/** Get ASP_Field_UU	  */
	public String getASP_Field_UU();

    /** Column name ASP_Status */
    public static final String COLUMNNAME_ASP_Status = "ASP_Status";

	/** Set ASP Status	  */
	public void setASP_Status (String ASP_Status);

	/** Get ASP Status	  */
	public String getASP_Status();

    /** Column name ASP_Tab_ID */
    public static final String COLUMNNAME_ASP_Tab_ID = "ASP_Tab_ID";

	/** Set ASP Tab	  */
	public void setASP_Tab_ID (int ASP_Tab_ID);

	/** Get ASP Tab	  */
	public int getASP_Tab_ID();

	public org.compiere.model.I_ASP_Tab getASP_Tab() throws RuntimeException;

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
