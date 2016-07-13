package com.oocl.mnlbc.aop;

public class ProxyPatternDemo {
	public static void main(String[] args) {
		ProxyBook book = new ProxyBook("Breaking Dawn", "Stephanie Meyer");
		book.addBook();
		book.addBook();
		}
}
