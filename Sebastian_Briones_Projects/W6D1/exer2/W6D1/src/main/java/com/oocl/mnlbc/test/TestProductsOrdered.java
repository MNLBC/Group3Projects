package com.oocl.mnlbc.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.entity.Order;
import com.oocl.mnlbc.entity.Product;

public class TestProductsOrdered {

	public static void main(String[] args) {
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink");
			EntityManager em = entityManagerFactory.createEntityManager();

			Order order = em.find(Order.class, 111L);
			System.out.println("Product details for order 111 : ");
			for (Product prod : order.getProductList()) {
				System.out.println("Product id : " + prod.getProdId());
				System.out.println("Product name : " + prod.getProdName());
			}
			em.close();
			entityManagerFactory.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
