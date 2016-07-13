package com.oocl.mnlbc.daoImpl;

import com.oocl.mnlbc.dao.Book;
/**
 * 
 * @author CUNTAAL
 *
 */
public class BookProxy implements Book {
	private BookImpl bookImpl;

	public BookProxy(BookImpl bookImpl) {
		this.bookImpl = bookImpl;
	}

	@Override
	public void addBook() {
		System.out.println("Transaction processing before");
		bookImpl.addBook();
		System.out.println("Transaction processing");
	}

}
