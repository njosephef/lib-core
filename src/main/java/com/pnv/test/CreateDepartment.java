/*
 * CreateDepartment.java
 *
 * Copyright by Orell Füssli Wirtschaftsinformationen AG
 * Zürich
 * All rights reserved.
 */
package com.pnv.test;

import java.util.Arrays;

import com.pnv.dao.DepartmentDao;
import com.pnv.domain.Department;
import com.pnv.domain.Employee;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class CreateDepartment
{
    /**
     * Method description
     *
     * @param args
     */
    public static void main(String[] args)
    {
    	DepartmentDao dao = new DepartmentDao();
    	Department department1 = new Department("R&D");
    	
        Employee employee1 = new Employee("Nguyen", "AAA", "123456");
        employee1.setPosition("Senior");
        employee1.setDepartment(department1);

        Employee employee2 = new Employee("Tran", "BBB", "123457");
        employee2.setPosition("Senior");
        employee2.setDepartment(department1);
        
        Employee employee3 = new Employee("Tran", "CCC", "123458");
        employee3.setPosition("Junior");
        employee3.setDepartment(department1);
        
        department1.setEmployeeList(Arrays.asList(employee1, employee2, employee3));

        dao.save(department1);

        Department department2 = new Department("HR");
        Employee employee4 = new Employee("Nguyen", "AAA", "123456");
        employee4.setPosition("Senior");
        employee4.setDepartment(department2);

        Employee employee5 = new Employee("Tran", "BBB", "123457");
        employee5.setPosition("Senior");
        employee5.setDepartment(department2);
        
        Employee employee6 = new Employee("Tran", "CCC", "123458");
        employee6.setPosition("Junior");
        employee6.setDepartment(department2);
        
        department2.setEmployeeList(Arrays.asList(employee4, employee5, employee6));

        dao.save(department2);

    }

}


/*
 * Changes:
 * $Log: $
 */