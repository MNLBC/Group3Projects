package com.oocl.mnlbc.proxy.dynamic2;

public class Main {

	public static void main(String[] args) {
		BookCGLib bookCGlib = new BookCGLib();
		BookFacade bookFacade = (BookFacade) bookCGlib.getInstance(new Book("Mathematics"));
		bookFacade.addBook();
		BookFacade bookFacade2 = (BookFacade) bookCGlib.getInstance(new Book("English Book"));
		bookFacade2.addBook();
	}
}
