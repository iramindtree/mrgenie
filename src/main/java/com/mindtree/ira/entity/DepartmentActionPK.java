package com.mindtree.ira.entity;

import java.io.Serializable;

/**
 * The primary key class for the department_action database table.
 * 
 */
public class DepartmentActionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String departmentCode;

	private String actionCode;

	public DepartmentActionPK() {
	}
	public String getDepartmentCode() {
		return this.departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public String getActionCode() {
		return this.actionCode;
	}
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DepartmentActionPK)) {
			return false;
		}
		DepartmentActionPK castOther = (DepartmentActionPK)other;
		return 
			this.departmentCode.equals(castOther.departmentCode)
			&& this.actionCode.equals(castOther.actionCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.departmentCode.hashCode();
		hash = hash * prime + this.actionCode.hashCode();
		
		return hash;
	}
}