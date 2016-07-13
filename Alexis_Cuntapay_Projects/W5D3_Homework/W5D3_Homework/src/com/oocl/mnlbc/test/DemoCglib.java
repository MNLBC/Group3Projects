package com.oocl.mnlbc.test;

import com.oocl.mnlbc.dao.BookFacadeCglib;
import com.oocl.mnlbc.daoImpl.BookFacadeImplCglib;

/**
 * 
 * @author CUNTAAL
 *
 */
public class DemoCglib {

	public static void main(String[] args) {
		BookFacadeCglib cglib = new BookFacadeCglib();
		BookFacadeImplCglib bookCglib = (BookFacadeImplCglib) cglib.getInstance(new BookFacadeImplCglib());
		bookCglib.addBook();
	}
}