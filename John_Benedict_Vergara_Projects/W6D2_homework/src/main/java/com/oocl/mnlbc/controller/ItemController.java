/**
 * 
 */
package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.entity.Items;
import com.oocl.mnlbc.service.ItemService;

/**
 * @author VERGAJO
 *
 */

@Controller
@ResponseBody
public class ItemController {

	@RequestMapping("/getItemById/{id}")
	public Items getUserById(@PathVariable("id") String itemId) {
		// Items item = new Items();
		// item.setItemId("1");
		// item.setItemName("BAG");
		// item.setItemCategory("School Supplies");
		// item.setItemPrice(1);
		// item.setItemStock(1);

		ItemService itemService = new ItemService();
		itemService.init();

		List<Items> items = itemService.getItem();
		Items result = null;
		for (Items item : items) {
			if (item.getItemId().equals(itemId)) {
				result = item;
			}
		}

		return result;
		// Items items = new Items();
		// items.setUserId(itemId);
		// items.setUsername("JayBee");
		// return user;
	}

}
