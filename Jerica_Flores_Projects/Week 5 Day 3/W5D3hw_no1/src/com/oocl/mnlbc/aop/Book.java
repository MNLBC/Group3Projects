package com.oocl.mnlbc.aop;

public class Book implements BookFacade{
	private String bookTitle;
	private String author;

	public Book(String bookTitle, String author){
	      this.bookTitle = bookTitle;
	      this.author = author;
	      loadFromDisk(bookTitle,author);
	   }

	   public void addBook() {
		   System.out.println("Added... Book title:" + bookTitle + "Author:" + author);
	   }

	   private void loadFromDisk(String bookTitle,String author){
	      System.out.println("Adding... " + bookTitle + " by " + author);
	   }

}
