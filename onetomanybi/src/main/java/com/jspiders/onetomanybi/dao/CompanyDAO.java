package com.jspiders.onetomanybi.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomanybi.dto.CompanyDTO;
import com.jspiders.onetomanybi.dto.EmployeeDTO;

public class CompanyDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

public static void main(String[] args) {
	CompanyDTO company=new CompanyDTO();
	company.setName("Accenture");
	company.setLocation("Pune");
	
	EmployeeDTO employee1=new EmployeeDTO();
	employee1.setName("Raj");
	employee1.setEmail("raj@gmail.com");
	employee1.setMobile(9096210620l);
	employee1.setCompany(company);
	
	EmployeeDTO employee2=new EmployeeDTO();
	employee2.setName("Vijay");
	employee2.setEmail("vijay@gmail.com");
	employee2.setMobile(8096456787l);
	employee2.setCompany(company);

	EmployeeDTO employee3=new EmployeeDTO();
	employee3.setName("Sanjay");
	employee3.setEmail("sanjay@gmail.com");
	employee3.setMobile(7096456787l);
	employee3.setCompany(company);
	
    company.setEmployee(Arrays.asList(employee1,employee2,employee3));
	openConnection();
	entityTransaction.begin();
	entityManager.persist(company);
	entityTransaction.commit();
	closeConnection();
}
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("company");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	private static void closeConnection() {
		if(entityManagerFactory!=null) {
			entityManagerFactory.close();
		}
		if(entityManager!=null) {
			entityManager.close();
		}
		if(entityTransaction!=null) {
			if(entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}


}
