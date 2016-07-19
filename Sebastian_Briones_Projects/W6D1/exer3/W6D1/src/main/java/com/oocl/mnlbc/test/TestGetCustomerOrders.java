package com.oocl.mnlbc.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.entity.User;
import com.oocl.mnlbc.entity.Order;

public class TestGetCustomerOrders {

	public static void main(String[] args) {
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink");
			EntityManager em = entityManagerFactory.createEntityManager();

			User customer = em.find(User.class, 100L);
			for (Order order : customer.getOrders()) {
				System.out.println("Orders id : " + order.getOrderId());
				System.out.println("Orders desc : " + order.getOrderDesc());
				System.out.println("Total price: " + order.getTotPrice());
			}

			em.close();
			entityManagerFactory.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
