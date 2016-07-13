package com.oocl.mnlbc.proxy.one;

public class Test {
	public static void main(String[] args) {
		BookFacade book = new ProxyBook("title", "author");
		book.addBook();
	}
}
