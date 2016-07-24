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
		long userId = cartItemList.getUserId();

		try {
			entityManager.getTransaction().begin();

			for (CartItem item : cartItemList.getItems()) {
				item.setUserId(userId);
				entityManager.persist(item);

			}
			entityManager.getTransaction().commit();

			return true;
		} catch (PersistenceException e) {
			return false;
		} catch (Exception e){
			return false;
		}

	}

	@Override
	public List<CartItem> loadCart(long userId) {
		Query query = entityManager.createQuery("SELECT CI FROM CartItem CI WHERE CI.userId = :userId");
		query.setParameter("userId", userId);

		try {
			List<CartItem> result = query.getResultList();
			return result;
		} catch (PersistenceException e) {
			return null;
		}

	}

	@Override
	public boolean removeUserCart(long userId) {
		Query query = entityManager.createQuery("SELECT CI FROM CartItem CI WHERE CI.userId = :userId");
		query.setParameter("userId", userId);

		try {
			List<CartItem> cartItemList = query.getResultList();
			entityManager.getTransaction().begin();
			for (CartItem item : cartItemList) {
				entityManager.remove(item);
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
		Query query = entityManager.createQuery("SELECT CI FROM CartItem CI WHERE CI.userId = :userId");
		query.setParameter("userId", userId);
		try {
			List<CartItem> cartItemList = query.getResultList();
			return cartItemList.size() > 0;
		} catch (PersistenceException e) {
			return false;
		}
	}

}
