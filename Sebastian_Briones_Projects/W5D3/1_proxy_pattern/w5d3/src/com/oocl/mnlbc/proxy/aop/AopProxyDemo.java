package com.oocl.mnlbc.proxy.aop;

public class AopProxyDemo {

	public static void main(String[] args) {

		BookFacade book = new BookProxy("Sebastian");

		book.showAuthor();
		System.out.println("");

		book.showAuthor();
	}

}
