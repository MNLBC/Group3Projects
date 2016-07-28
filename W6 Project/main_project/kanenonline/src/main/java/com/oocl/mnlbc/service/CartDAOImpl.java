/**
 * 
 */
package com.oocl.mnlbc.service;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.oocl.mnlbc.dao.CartDAO;
import com.oocl.mnlbc.entity.CartItem;
import com.oocl.mnlbc.model.CartItemList;

/**
 * @author VERGAJO
 *
 */
public class CartDAOImpl extends AbstractJPAGenericDAO<CartItem> implements CartDAO {

	@Override
	@Transactional
	public boolean saveCart(CartItemList cartItemList) {
		// Gets the userId from the CartItemList
		long userId = cartItemList.getUserId();

		try {
			if (!entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().begin();
			}
			// iterates the items from the CartItemList and map it to CartItem
			for (CartItem item : cartItemList.getItems()) {
				// sets the userId of the item
				item.setUserId(userId);
				// Saves the item to CART_ITEM table in the database since we
				// use CartItem Entity to map the object
				entityManager.persist(item);
			}
			entityManager.getTransaction().commit();

			return true;
		} catch (PersistenceException e) {
			return false;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public List<CartItem> loadCart(long userId) {
		// Load all the cartItem of the certain user using the userId
		Query query = entityManager.createQuery("SELECT CI FROM CartItem CI WHERE CI.userId = :userId");
		// sets the parameter of the Entity Query
		query.setParameter("userId", userId);

		try {
			// Executes the query and get the resultList then Map it to CartItem
			List<CartItem> result = query.getResultList();
			return result;
		} catch (PersistenceException e) {
			return null;
		}

	}

	@Override
	public boolean removeUserCart(long userId) {
		// remove the cartItem of the certain user using the userId
		Query query = entityManager.createQuery("SELECT CI FROM CartItem CI WHERE CI.userId = :userId");
		// sets the parameter of the Entity Query
		query.setParameter("userId", userId);

		try {
			// Executes the query and get the resultList then Map it to CartItem
			List<CartItem> cartItemList = query.getResultList();

			if (!entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().begin();
			}

			// iterates the items from the CartItemList and map it to CartItem
			for (CartItem item : cartItemList) {
				// deletes the certain item from the CartItem Table in the
				// database
				entityManager.remove(item);
				if (!entityManager.getTransaction().isActive()) {
					entityManager.getTransaction().begin();
				}
			}
			entityManager.getTransaction().commit();
			return true;
		} catch (PersistenceException e) {
			return false;
		}

	}

	@Override
	public CartItem findById(long id) {

		return null;
	}

	@Override
	public CartItem update(CartItem t) {

		return null;
	}

	@Override
	public boolean findCartByUser(long userId) {
		//// Load all the cartItem of the certain user using the userId
		Query query = entityManager.createQuery("SELECT CI FROM CartItem CI WHERE CI.userId = :userId");
		query.setParameter("userId", userId);
		try {
			// Executes the query and get the resultList then Map it to CartItem
			List<CartItem> cartItemList = query.getResultList();
			return cartItemList.size() > 0;
		} catch (PersistenceException e) {
			return false;
		}
	}

}
