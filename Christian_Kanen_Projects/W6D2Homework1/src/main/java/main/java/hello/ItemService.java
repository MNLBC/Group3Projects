package main.java.hello;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class ItemService {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("unitEclipseLink", new java.util.HashMap());
		System.out.println(entityManagerFactory.getClass().getSimpleName());
		entityManager = entityManagerFactory.createEntityManager();
		System.out.println(entityManager.getClass().getSimpleName());

	}
	
	public  String createItem(EntityManager em, Items item) {
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
        return item.getItemId();
    }

    public  Items getItemId(EntityManager em, String itemId) {
        Items item = em.find(Items.class, itemId);
        return item;
    }

    public Items updateItem(EntityManager em, Items item) {
        em.getTransaction().begin();
        em.merge(item);
        em.getTransaction().commit();
        return item;
    }

    public void removeRegion(EntityManager em, Items item) {
        em.getTransaction().begin();
        em.remove(item);
        em.getTransaction().commit();
    }
    public List<Items> getItemList(String itemId) {
        return entityManager.createQuery("select t from Items t where :itemId").getResultList();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

	

}
