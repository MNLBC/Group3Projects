package com.oocl.mnlbc.aop;

public class ProxyBook implements BookFacade {
	private Book book;
	private String bookTitle;
	private String author;

	public ProxyBook(String bookTitle, String author){
	this.bookTitle = bookTitle;
	this.author = author;
	}

	public void addBook(){
	if(book == null){
	         book = new Book(bookTitle, author);
	      }
	      book.addBook();
	   }
	
}
