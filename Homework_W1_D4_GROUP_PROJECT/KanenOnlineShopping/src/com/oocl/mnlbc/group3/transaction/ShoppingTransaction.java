/**
 * 
 */
package com.oocl.mnlbc.group3.transaction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.oocl.mnlbc.group3.model.Customer;
import com.oocl.mnlbc.group3.model.Product;
import com.oocl.mnlbc.group3.model.Warehouse;
import com.oocl.mnlbc.group3.util.Validators;

/**
 * @author Group3
 *
 */
public class ShoppingTransaction {

	Customer cust;
	BufferedReader input;
	Warehouse warehouse;
	Validators validate;

	List<Product> cart;
	
	/**
	 * Constructor of the Transaction class
	 */

	public ShoppingTransaction() {
		input = new BufferedReader(new InputStreamReader(System.in));
		warehouse = new Warehouse();
		validate = new Validators();
	}

	/**
	 * the method for the Registration.
	 * @throws IOException
	 */
	public void registerUser() throws IOException {

		System.out.println("Register now!");

		String firstName;
		String lastName;
		String userName;
		String emailAddress;
		String mobileNumber;
		String balance;
		System.out.print("Enter your first name: ");
		firstName = input.readLine();
		System.out.print("Enter your last name: ");
		lastName = input.readLine();
		System.out.print("Enter a user name: ");
		userName = input.readLine();
		do {
			System.out.print("Enter your email address: ");
			emailAddress = input.readLine();
		} while (!validate.checkEmail(emailAddress));
		do {
			System.out.print("Enter your mobile number: ");
			mobileNumber = input.readLine();
		} while (!validate.checkPhone(mobileNumber));

		
		System.out.print("Enter your balance: ");
		balance = input.readLine();
		cust = new Customer(1, firstName, lastName, userName, emailAddress, mobileNumber,Double.parseDouble(balance));

		System.out.println("Logging on automatically.");
		System.out.println(cust.toString());
		System.out.println();
		pressAnyKeyToContinue();
	}
	
	/**
	 * this method adds balance to the customer
	 * @throws NumberFormatException
	 * @throws IOException
	 */

	public void addBalance() throws NumberFormatException, IOException {
		String amount = "";
			System.out.print("How much balance will you add?: $");
			// Scanner input = new Scanner(System.in);
			amount = input.readLine();

		cust.setBalance(Integer.parseInt(amount) + cust.getBalance());
		System.out.println("Your new balance is: " + cust.getBalance());

		pressAnyKeyToContinue();
	}
/**
 * just display the transaction options
 */
	public void displayOptions() {

		System.out.println("Please select transaction: [1-5]");
		System.out.println("[1]  Shop Now!");
		System.out.println("[2]  Check our products!");
		System.out.println("[3]  Check your balance.");
		System.out.println("[4]  Deposit additional balance.");
		System.out.println("[5]  Logout.");

	}
	
	/**
	 * takes the input for the choices of transaction option
	 * @return
	 * @throws IOException
	 */

	public String readOption() throws IOException {
		boolean inputValid = false;
		String choiceStr = "";
		do {
			System.out.print("Enter your Transaction No.: ");
			choiceStr = input.readLine();
			if (choiceStr.equals("1") || choiceStr.equals("2") || choiceStr.equals("3") || choiceStr.equals("4")
					|| choiceStr.equals("5")) {
				inputValid = true;
			} else {
				System.out.println("Please select a number between [1-5] only.");
			}
		} while (!inputValid);

		return choiceStr;

	}

	/**
	 * method for checking the balance
	 */
	public void checkBalance() {

		System.out.println("Current Balance: " + cust.getBalance());
		pressAnyKeyToContinue();
	}
/**
 * displaying the product list
 */
	public void displayProduct() {

		warehouse.listProducts();
		pressAnyKeyToContinue();

	}

	/**
	 *
	 * This method will do the Transaction of Ordering of user Add List of
	 * Products to Order List and Use warehouse to get and minus the stock of
	 * the order. Display current order list
	 * 
	 */
	public void placeAnOrder() throws IOException {
		int prodNumber = 0;
		double quantity;
		double itemsSubtotal = 0;
		double totalAmount = 0;

		cart = new ArrayList<Product>();

		String proceed;
		int ctr = 0;

		do {
			Product prod = null;
			warehouse.listProducts();
			// Scanner input = new Scanner(System.in);

			while (prod == null) {
				System.out.println("Choose an Item");
				System.out.print("Enter Product ID: ");
				prodNumber = Integer.parseInt(input.readLine());
				prod = warehouse.getProduct(prodNumber);
				if (prod == null) {
					System.out.println("Choose a valid product");
				}
			}
			cart.add(prod);
			
			do {
				System.out.print("Enter Quantity: ");
				quantity = Double.parseDouble(input.readLine());

				if (prod.getInStock() < quantity) {
					System.out.println("Insuficient Stocks. Current stocks left: " + prod.getInStock());
					quantity = 0;
				}
				else{
				itemsSubtotal = (cart.get(ctr).getPrice() * quantity);
				cart.get(ctr).setInStock((int) quantity);
				ctr++;
				}
			} while (quantity == 0);

			totalAmount += itemsSubtotal;
			System.out.println("Items Subtotal: " + itemsSubtotal);
			System.out.println("Total Amount: " + totalAmount);

			System.out.print("Add another product?[y/n]: ");
			proceed = input.readLine();

		} while (proceed.equalsIgnoreCase("y"));
		totalAmount = 0;
		for (Product item : cart) {
			totalAmount += (item.getPrice() * item.getInStock());
		}

		System.out.println("Final Amount: " + totalAmount);
		System.out.println("Order status: Order Committed!");

		System.out.println("You are now proceeding to payment...");
		pressAnyKeyToContinue();
		doPayment(totalAmount);
		System.out.println("Order status: Payment Success!");
		doWarehousing();
		System.out.println("You are now proceeding to delivery");
		pressAnyKeyToContinue();
		System.out.println("Order status: Delivery out of storage! shipping....");
		System.out.println("Order status: Ready to receive products from users!");
		System.out.println("Press Enter to Confirm if Package Received.");
		try {
			Scanner input = new Scanner(System.in);
			input.nextLine();
		} catch (Exception e) {
		}
		System.out.println("Order status: Finished!");
		System.out.println("Product has been Recieved. Thanks for shopping @ Kanen Online Shopping...");
		System.out.println("Returning to main page");
		pressAnyKeyToContinue();

	}

	/**
	 * This method will compute the transaction if user has proceed to payment
	 * New Balance = Current Balance - Total Price of Transaction Display New
	 * balance of customer.
	 * 
	 * @param totalPrice
	 */
	public void doPayment(double totalPrice) throws IOException {
		System.out.println("");
		String proceed = "";
		double currentBalance = cust.getBalance();
		double totalCost = 0;
		double remainingBalance;

		if (currentBalance >= totalPrice) {
			remainingBalance = currentBalance - totalPrice;
			cust.setBalance(remainingBalance);
			System.out.println("Order created.");
			System.out.println("Your remaining balance is " + remainingBalance);
		} else {
			System.out.println("Insufficient Balance.");
			System.out.println("Your cart items are:");

			for (Product item : cart) {
				System.out.println(item.getProductName() + "- quantity: " + item.getInStock());
				totalCost += item.getPrice() * item.getInStock();

			}
			System.out.print("Do you want to reset your cart or cancel transaction[r/c]?: ");
			proceed = input.readLine();
			if (proceed.equalsIgnoreCase("r")) {
				cart = null;
				placeAnOrder();
			} else {
				displayOptions();
				readOption();
			}

			System.out.println("Total cost: " + totalCost);
			System.out.println("Your current balance is " + currentBalance);
			pressAnyKeyToContinue();

		}

		printReciept();
		System.out.println("Reciept has been printed!!");

	}
/**
 * printing the receipt using the file writer
 * @throws IOException
 */
	public void printReciept() throws IOException {

		File file = new File("D:\\receipts\\order_Reciept.txt");
		file.getParentFile().mkdirs();
		file.createNewFile();
		FileWriter writer = new FileWriter(file);

		writer.append("***Kanen Online Shopping***\n");
		writer.append("Order reciept.\n");
		writer.append("Sold to:" + cust.getFirstName() + " " + cust.getLastName() + "\n");
		writer.append("\n");
		writer.append("Items:\n");
		double totalCost = 0;
		double itemSubtotal = 0;

		for (Product item : cart) {
			itemSubtotal = item.getPrice() * item.getInStock();
			totalCost += itemSubtotal;
			writer.append("\t" + item.getProductName() + " " + item.getInStock() + " x " + item.getPrice() + "\t"
					+ itemSubtotal + "\n");
		}

		writer.append("\n \t \t \t Total cost: " + totalCost);
		writer.flush();
		writer.close();

	}

	private void pressAnyKeyToContinue() {
		System.out.println("Press Enter to continue...\n");
		try {
			Scanner input = new Scanner(System.in);
			input.nextLine();
		} catch (Exception e) {
		}
	}
/**
 * this does the warehousing removing the stocks inside the warehouse.
 */
	private void doWarehousing() {
		for (Product prod : cart) {
			Product warhouseProduct = warehouse.getWarehousProduct(prod.getProductId());
			warhouseProduct.setInStock(warhouseProduct.getInStock() - prod.getInStock());
			if (warhouseProduct.getInStock() == 0) {
				warehouse.getProductSelection().remove(warhouseProduct);
			}

		}
	}

}
