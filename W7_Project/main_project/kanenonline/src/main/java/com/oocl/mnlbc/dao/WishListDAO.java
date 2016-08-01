/**
 * 
 */
package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.entity.WishList;

/**
 * @author VERGAJO
 *
 */
public interface WishListDAO extends GenericDAO<WishList> {

	long saveWishList(long userId, long productId, String productName, String productDescription, long productPrice, String imagePath);

	boolean clearUserWishList(long userId);

	boolean removeFromWishList(long wishListId);

	List<WishList> loadUserWishList(long userId);

}
