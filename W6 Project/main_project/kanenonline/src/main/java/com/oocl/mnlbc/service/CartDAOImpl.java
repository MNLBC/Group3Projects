/**
 * 
 */
package com.oocl.mnlbc.service;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.oocl.mnlbc.dao.CartDAO;
import com.oocl.mnlbc.entity.CartItem;
import com.oocl.mnlbc.model.CartItemList;
import com.oocl.mnlbc.model.OrdersAndItems;
import com.oocl.mnlbc.model.Response;
import com.oocl.mnlbc.security.AbstractJPAGenericDAO;
import com.oocl.mnlbc.utils.CollectionUtils;

/**
 * @author VERGAJO
 *
 */
public class CartDAOImpl extends AbstractJPAGenericDAO<CartItem> implements CartDAO {

	@Override
	public boolean saveCart(CartItemList cartItemList) {
		long userId = cartItemList.getUserId();
		CartItem cartItem = new CartItem();
		cartItem.setUserId(userId);

		try {
			entityManager.getTransaction().begin();
			for (CartItem item : cartItemList.getItems()) {
				cartItem.setProductId(item.getProductId());
				cartItem.setProductName(item.getProductName());
				cartItem.setProductDescription(item.getProductDescription());
				cartItem.setQuantity(item.getQuantity());
				cartItem.setProductPrice(item.getProductPrice());
				cartItem.setImagePath(item.getImagePath());
				entityManager.persist(cartItem);
				return true;
			}
			entityManager.getTransaction().commit();
		} catch (PersistenceException e) {
			return false;
		}
		return false;

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

}
