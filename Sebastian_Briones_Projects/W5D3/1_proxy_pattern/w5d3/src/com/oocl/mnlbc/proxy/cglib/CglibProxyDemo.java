package com.oocl.mnlbc.proxy.cglib;

public class CglibProxyDemo {

	public static void main(String[] args) {
		BookFacadeProxy bookProxy = new BookFacadeProxy();
		BookFacadeImpl book = (BookFacadeImpl) bookProxy.getInstance(new BookFacadeImpl());
		book.addBook();
	}
}
