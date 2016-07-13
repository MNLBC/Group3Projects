package com.oocl.mnlbc.proxy.two;

public class Test {

	public static void main(String[] args) {
		ProxyBook proxy = new ProxyBook();
		BookFacade bookProxy = (BookFacade) proxy.bind(new RealBook("title", "author"));

		bookProxy.addBook();
	}

}
