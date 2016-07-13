package com.oocl.mnlbc.proxy.dynamic;

public class DynamicProxyDemo {

	
	public static void main(String[] args) {

		BookFacadeProxy bookProxy = new BookFacadeProxy();
		BookFacade book = (BookFacade) bookProxy.bind(new BookFacadeImpl());
		
		book.addBook();
	}

}
