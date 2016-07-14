package com.oocl.mnlbc.homework.w5d3.aop;

public class ProxyPatternDemo {
	
	   public static void main(String[] args) {
	      BookFacade book = new ProxyBook("Real Ghost Stories");

	      book.addBook(); 
	      System.out.println("");

	      book.addBook();  	
	   }
}