package com.oocl.mnlbc.app_controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oocl.mnlbc.entity.Item;
import com.oocl.mnlbc.service.ItemService;

@Controller
@ResponseBody
public class ItemController {
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/getItems/item/{itemId}")
	public Item item(@PathVariable("itemId") String itemId) {
		ItemService is = new ItemService();
		is.init();
		EntityManager em = is.getEntityManager();
		List<Item> ilist = is.getItems();
		Item output = null;

		for (Item i : ilist) {
			if (i.getItemId().equals(itemId)) {
				output = i;
			}
		}
		return output;
	}
}
