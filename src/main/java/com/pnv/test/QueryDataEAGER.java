package com.pnv.test;

import java.util.List;

import com.pnv.dao.DepartmentDao;
import com.pnv.domain.Department;

public class QueryDataEAGER {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DepartmentDao dao = new DepartmentDao();
		Department department = dao.findById(Long.valueOf(1));
		System.out.println("Department: " + department.getName());
		System.out.println("Number of employee: " + department.getEmployeeList().size());
		
		System.out.println("======================================================================");
		List<Department> list = dao.findAll();
		System.out.println(list.size());
		for (Department department2 : list) {
			System.out.println("Department: " + department2.getName());
			System.out.println("Number of employee: " + department2.getEmployeeList().size());
		}
	}
}
