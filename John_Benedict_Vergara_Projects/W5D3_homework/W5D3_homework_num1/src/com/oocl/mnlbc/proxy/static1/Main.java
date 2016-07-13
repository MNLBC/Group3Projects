package com.oocl.mnlbc.proxy.static1;

public class Main {
	public static void main(String[] args) {
	      BookFacade bookFacade = new Book("Harry Potter");
	      //loaded from disk
	      bookFacade.addBook();
	      //not loaded from disk
	      bookFacade.addBook(); 	
	   }
}
