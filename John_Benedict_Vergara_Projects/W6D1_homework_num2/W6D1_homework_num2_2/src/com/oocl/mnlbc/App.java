package com.oocl.mnlbc;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.oocl.mnlbc.model.Product;
import com.oocl.mnlbc.model.Book;

public class App {

	private static EntityManager em = null;

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DEMO_PU");

		em = emf.createEntityManager();

		Product item1 = new Product();
		item1.setName("Ghost Stories");

		Product item2 = new Product();
		item2.setName("Harry Potter");

		Book category1 = new Book();
		category1.setName("Phone");

		Book category2 = new Book();
		category2.setName("Bag");

		item1.getCateGory().add(category1);
		item2.getCateGory().add(category1);

		item1.getCateGory().add(category2);
		item2.getCateGory().add(category2);

		saveItem(item1);
		saveItem(item2);

		// Update item
		Book category3 = new Book();
		category3.setName("Car");
		item1.getCateGory().add(category3);
		Product itemCopy = updateItem(item1);

		// Find item by id
		Product itemLoaded = findItemById(itemCopy.getId());
		System.out.println("Item ID " + itemLoaded.getId());
		System.out.println("Cartory of Item: " + itemLoaded.getCateGory().size());

		// Delete item
		delteItem(itemLoaded);

	}

	public static void saveItem(Product item) {
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
		System.out.println("Persist Item");
	}

	public static Product updateItem(Product item) {
		em.getTransaction().begin();
		Product itemCopy = em.merge(item);
		em.getTransaction().commit();
		System.out.println("Update Item");
		return itemCopy;

	}

	public static Product findItemById(long id) {

		Product itemLoaded = em.find(Product.class, id);
		System.out.println("Find Item by Id");
		return itemLoaded;

	}

	public static void delteItem(Product item) {
		em.getTransaction().begin();
		em.remove(item);
		em.getTransaction().commit();
		System.out.println("Item Removed");

	}

}
