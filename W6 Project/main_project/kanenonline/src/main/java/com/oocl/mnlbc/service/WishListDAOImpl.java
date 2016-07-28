/**
 * 
 */
package com.oocl.mnlbc.service;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.oocl.mnlbc.dao.WishListDAO;
import com.oocl.mnlbc.entity.WishList;

/**
 * @author VERGAJO
 *
 */
public class WishListDAOImpl extends AbstractJPAGenericDAO<WishList> implements WishListDAO {

	@Override
	public long saveWishList(long userId, long productId, String productName, String productDescription, long productPrice, String imagePath) {
		try {
			
			WishList wishListItem = new WishList();
			wishListItem.setUserId(userId);
			wishListItem.setProductId(productId);
			wishListItem.setProductName(productName);
			wishListItem.setProductDescription(productDescription);
			wishListItem.setProductPrice(productPrice);
			wishListItem.setImagePath(imagePath);
			
			entityManager.getTransaction().begin();
			entityManager.persist(wishListItem);
			entityManager.getTransaction().commit();
			long wishListId = wishListItem.getWishListId();
			
			return wishListId;
		} catch (PersistenceException e) {
			e.printStackTrace();
			return 0;
		} catch (Exception e){
			e.printStackTrace();
			return 0;
		}

	}


	@Override
	public boolean removeFromWishList(long wishListId) {

		Query query = entityManager.createQuery("SELECT W FROM WishList W WHERE W.wishListId = :wishListId");
		// sets the parameter of the Entity Query
		query.setParameter("wishListId", wishListId);

		try {
			// Executes the query and get the resultList then Map it to WishList
			WishList wishListItem = (WishList) query.getSingleResult();

			entityManager.getTransaction().begin();

			entityManager.remove(wishListItem);

			entityManager.getTransaction().commit();

			return true;
		} catch (PersistenceException e) {
			return false;
		}

	}

	@Override
	public boolean clearUserWishList(long userId) {
		Query query = entityManager.createQuery("SELECT W FROM WishList W WHERE W.userId = :userId");
		// sets the parameter of the Entity Query
		query.setParameter("userId", userId);

		try {
			// Executes the query and get the resultList then Map it to WishList
			List<WishList> wishList = query.getResultList();

			entityManager.getTransaction().begin();
			// iterates the items from the wishList and map it to WishList
			for (WishList item : wishList) {
				// deletes the certain item from the WishList Table in the
				// database
				entityManager.remove(item);
			}
			entityManager.getTransaction().commit();
			return true;
		} catch (PersistenceException e) {
			return false;
		}
	}
	

	@Override
	public List<WishList> loadUserWishList(long userId) {
		// TODO Auto-generated method stub

		Query query = entityManager.createQuery("SELECT W FROM WishList W WHERE W.userId = :userId");
		// sets the parameter of the Entity Query
		query.setParameter("userId", userId);

		try {

			List<WishList> result = query.getResultList();
			return result;
		} catch (PersistenceException e) {
			return null;
		}

	}

}
