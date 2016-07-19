/**
 * 
 */
package com.oocl.mnlbc.controller;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oocl.mnlbc.entity.Items;
import com.oocl.mnlbc.service.ItemService;

/**
 * @author VERGAJO
 *
 */

@SpringBootApplication
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(App.class, args);
//
//		ItemService itemService = new ItemService();
//		itemService.init();
//		itemService.getItem();
//
//		List<Items> itemsList = itemService.getItem();
//		for (Items item : itemsList) {
//			System.out.println("Item ID: " + item.getItemId() + "Item Name: " + item.getItemName() + "Item Category: "
//					+ item.getItemCategory() + "Item Stock: " + item.getItemStock() + "Item Price: "
//					+ item.getItemPrice());
//		}
	}

}
