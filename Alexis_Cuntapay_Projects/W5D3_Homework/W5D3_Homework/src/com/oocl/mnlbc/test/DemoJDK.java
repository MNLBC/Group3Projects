package com.oocl.mnlbc.test;

import com.oocl.mnlbc.dao.BookFacadeJDK;
import com.oocl.mnlbc.daoImpl.BookFacadeImpl;
import com.oocl.mnlbc.daoImpl.BookFacadeProxy;
/**
 * 
 * @author CUNTAAL
 *
 */
public class DemoJDK {

	public static void main(String[] args) {
		BookFacadeProxy proxy = new BookFacadeProxy();
		BookFacadeJDK bookProxy = (BookFacadeJDK) proxy.bind(new BookFacadeImpl());
		bookProxy.addBook();
	}

}