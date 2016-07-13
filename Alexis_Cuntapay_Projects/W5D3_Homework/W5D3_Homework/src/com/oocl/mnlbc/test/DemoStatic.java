package com.oocl.mnlbc.test;

import com.oocl.mnlbc.daoImpl.BookImpl;
import com.oocl.mnlbc.daoImpl.BookProxy;
/**
 * 
 * @author CUNTAAL
 *
 */
public class DemoStatic {
	public static void main(String[] args) {
		BookImpl bookImpl = new BookImpl();
		BookProxy bookProxy = new BookProxy(bookImpl);
		bookProxy.addBook();

	}
}