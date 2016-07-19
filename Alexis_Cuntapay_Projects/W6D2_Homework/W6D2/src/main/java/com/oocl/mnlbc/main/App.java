package com.oocl.mnlbc.main;

import javax.persistence.EntityManager;

import org.springframework.boot.SpringApplication;

import com.oocl.mnlbc.Item;
import com.oocl.mnlbc.services.ItemService;

public class App {

	public static void main(String[] args){
		SpringApplication.run(App.class, args);
	}
}
