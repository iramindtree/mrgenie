package com.mindtree.ira.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the department_action database table.
 * 
 */
@Entity
@Table(name="department_action")
@NamedQuery(name="DepartmentAction.findAll", query="SELECT d FROM DepartmentAction d")
public class DepartmentAction implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
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