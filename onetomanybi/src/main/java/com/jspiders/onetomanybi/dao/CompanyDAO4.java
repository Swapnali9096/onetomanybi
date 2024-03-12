package com.jspiders.onetomanybi.dao;



import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.onetomanybi.dto.CompanyDTO;
import com.jspiders.onetomanybi.dto.EmployeeDTO;

public class CompanyDAO4 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

public static void main(String[] args) {
	openConnection();
	entityTransaction.begin();
List<CompanyDTO> companyDTOs=findAll();
for (CompanyDTO companyDTO : companyDTOs) {
	
}
	entityTransaction.commit();
	closeConnection();
}
private static List<CompanyDTO> findAll() {
	Query query=entityManager.createQuery("SELECT company FROM CompanyDTO company");
	List<CompanyDTO> companyDTOs=query.getResultList();
	return companyDTOs;
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
