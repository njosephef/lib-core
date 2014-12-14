package com.pnv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue
    @Column(name = "EMPLOYEE_ID")
	private Long employeeId;
	
    @Column(name = "FIRST_NAME")
    private String firstName;
	
	@Column(name = "LAST_NAME")
    private String lastName;
	
    @Column(name = "POSITION")
    private String position;

    @Column(name = "CELL_PHONE")
    private String cellPhone;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", nullable = false)
    private Department department;

    /**
     * Constructor
     *
     */
	public Employee() {
		
	}
	

    /**
     * Constructor
     *
     * @param firstName
     * @param lastName
     * @param cellPhone
     */
    public Employee(String firstName, String lastName, String cellPhone)
    {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setCellPhone(cellPhone);
	}


    /**
     * Sets the employeeId
     *
     * @param employeeId The employeeId to set
     */
    public void setEmployeeId(Long employeeId)
    {
        this.employeeId = employeeId;
    }


    /**
     * Gets the employeeId
     *
     * @return Returns the employeeId
     */
    public Long getEmployeeId()
    {
        return employeeId;
    }


    /**
     * Sets the firstName
     *
     * @param firstName The firstName to set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }


    /**
     * Gets the firstName
     *
     * @return Returns the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }


    /**
     * Sets the lastName
     *
     * @param lastName The lastName to set
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }


    /**
     * Gets the lastName
     *
     * @return Returns the lastName
     */
    public String getLastName()
    {
        return lastName;
    }


    /**
     * Sets the cellPhone
     *
     * @param cellPhone The cellPhone to set
     */
    public void setCellPhone(String cellPhone)
    {
        this.cellPhone = cellPhone;
    }


    /**
     * Gets the cellPhone
     *
     * @return Returns the cellPhone
     */
    public String getCellPhone()
    {
        return cellPhone;
    }


    /**
     * Sets the department
     *
     * @param department The department to set
     */
    public void setDepartment(Department department)
    {
        this.department = department;
    }


    /**
     * Gets the department
     *
     * @return Returns the department
     */
    public Department getDepartment()
    {
        return department;
    }


    /**
     * Sets the position
     *
     * @param position The position to set
     */
    public void setPosition(String position)
    {
        this.position = position;
    }


    /**
     * Gets the position
     *
     * @return Returns the position
     */
    public String getPosition()
    {
        return position;
    }
	
}
