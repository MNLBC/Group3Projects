/**
 * 
 */
package com.oocl.mnlbc.dao;

import java.util.List;

import com.oocl.mnlbc.entity.CartItem;
import com.oocl.mnlbc.model.CartItemList;

/**
 * @author VERGAJO
 *
 */
public interface CartDAO extends GenericDAO<CartItem> {

	boolean saveCart(CartItemList items);

	List<CartItem> loadCart(long userId);

	boolean removeUserCart(long userId);

}
