package com.oocl.mnlbc.cglib;

public class ProxyPatternDemo {
	public static void main(String[] args) {
		BookCglib cglib = new BookCglib();
		BookFacade book = (BookFacade) cglib.getInstance(new RealBook());
		book.addBook();

	}
}