/*
 * Department.java
 *
 * Copyright by Orell Füssli Wirtschaftsinformationen AG
 * Zürich
 * All rights reserved.
 */
package com.pnv.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
@Entity
@Table
public class Department
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @Column(unique=true, nullable=false)
    private String name;
    
    @OneToMany(mappedBy = "department", orphanRemoval = true)
    @Cascade(CascadeType.SAVE_UPDATE)
    private List<Employee> employeeList = new ArrayList<Employee>();
    
    @Transient
    private String note;
    
    /**
     * Constructor
     *
     */
    public Department()
    {

    }


    /**
     * Constructor
     *
     * @param name
     */
    public Department(String name)
    {
        this.setName(name);
    }


    /**
     * Sets the departmentId
     *
     * @param departmentId The departmentId to set
     */
    public void setDepartmentId(Long departmentId)
    {
        this.departmentId = departmentId;
    }

    /**
     * Gets the departmentId
     *
     * @return Returns the departmentId
     */
    public Long getDepartmentId()
    {
        return departmentId;
    }

    /**
     * Sets the name
     *
     * @param name The name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the name
     *
     * @return Returns the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the employeeList
     *
     * @param employeeList The employeeList to set
     */
    public void setEmployeeList(List<Employee> employeeList)
    {
        this.employeeList = employeeList;
    }

    /**
     * Gets the employeeList
     *
     * @return Returns the employeeList
     */
    public List<Employee> getEmployeeList()
    {
        return employeeList;
    }


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}

}


/*
 * Changes:
 * $Log: $
 */