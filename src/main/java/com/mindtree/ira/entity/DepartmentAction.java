package com.mindtree.ira.entity;

import java.io.Serializable;


/**
 * The persistent class for the department_action database table.
 * 
 */
public class DepartmentAction implements Serializable {
	private static final long serialVersionUID = 1L;

	private DepartmentActionPK id;

	public DepartmentAction() {
	}

	public DepartmentActionPK getId() {
		return this.id;
	}

	public void setId(DepartmentActionPK id) {
		this.id = id;
	}

}