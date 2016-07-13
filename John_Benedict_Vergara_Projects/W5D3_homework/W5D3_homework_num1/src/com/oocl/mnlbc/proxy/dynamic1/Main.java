package com.oocl.mnlbc.proxy.dynamic1;

public class Main {

	public static void main(String[] args) {
		ProxyBook proxyBook = new ProxyBook();
		BookFacade bookFacade = (BookFacade) proxyBook.bind(new Book("Breaking Dawn"));
		bookFacade.addBook();
	}
}
