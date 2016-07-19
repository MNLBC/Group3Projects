package com.oocl.mnlbc.controller;

import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.EntityManager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.entity.Item;
import com.oocl.mnlbc.service.ItemService;



@RestController
public class ItemController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/getItemId")
	public Item getItemId(@RequestParam("itemId") int itemId) {
		
		ItemService ems = new ItemService();
		ems.init();
		EntityManager em = ems.getEntityManager();
		System.out.println("===========================================");
		Item result = null;
		for(Item item : ems.getItem(em)){
			if(item.getItemId()==itemId){
				result = item;
			}
		}
		System.out.println("===========================================");
		em.close();
		
		return result;
	}
	@RequestMapping("/getTest")
	public String getTest() {
	return "test";
	}
	
}
