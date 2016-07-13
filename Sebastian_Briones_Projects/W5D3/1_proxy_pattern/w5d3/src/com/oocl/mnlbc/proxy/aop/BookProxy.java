package com.oocl.mnlbc.proxy.aop;

public class BookProxy implements BookFacade {

	private RealBook realBook;
	private String author;

	public BookProxy(String author) {
		this.author = author;
	}

	public void showAuthor() {
		if (realBook == null) {
			realBook = new RealBook("Baste");
		}
		realBook.showAuthor();
		
	}
	
}