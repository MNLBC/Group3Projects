package com.oocl.mnlbc.group3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.oocl.mnlbc.group3.model.Item;
import com.oocl.mnlbc.group3.service.ItemDAOImpl;

@Controller
public class ItemController {

	@Autowired
	private ItemDAOImpl itemDAO;

	@ResponseBody
	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
	public Item getUserById(@PathVariable(value = "id") int itemId) {
		itemDAO.init();
		Item item = itemDAO.getItemById(itemId);
		return item;

	}
}
