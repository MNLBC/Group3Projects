package com.oocl.mnlbc.cglib;

import com.oocl.mnlbc.cglib.RealBook;

public class ProxyBook implements BookFacade {

	private RealBook realBook;
	private String bookTitle;
	private String author;

	public ProxyBook(String bookTitle, String author) {
		this.bookTitle = bookTitle;
		this.author = author;
	}

	@Override
	public void addBook() {
		if (realBook == null) {
			realBook = new RealBook(bookTitle, author);
		}
		realBook.addBook();
	}
}