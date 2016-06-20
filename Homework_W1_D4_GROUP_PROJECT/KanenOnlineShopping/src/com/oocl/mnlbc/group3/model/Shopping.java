package com.oocl.mnlbc.group3.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.oocl.mnlbc.group3.transaction.ShoppingTransaction;

public class Shopping {

/**
 * 
 * @param args
 * @throws IOException
 */
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		ShoppingTransaction txn = new ShoppingTransaction();
		System.out.println("Welcome to Kanen Online Shopping!");
		String option;
		txn.registerUser();

		do {
			txn.displayOptions();
			option = txn.readOption();
			switch (option) {
			case "1":
				txn.placeAnOrder();
				break;
			case "2":
				txn.displayProduct();
				break;
			case "3":
				txn.checkBalance();
				break;
			case "4":
				txn.addBalance();
				break;
			case "5":
				System.out.println("Logged out!");
				System.exit(0);
				break;
			default:
				break;
			}
			System.out.println("");
		} while (!option.equals("5"));
	}
}
