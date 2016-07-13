package com.oocl.mnlbc.jdk;

public class RealBook implements BookFacade {

	   private String bookTitle;
	   private String author;

	   public RealBook(String bookTitle, String author){
	      this.bookTitle = bookTitle;
	      this.author = author;
	      loadFromDisk(bookTitle, author);
	   }

	   public void display() {
	      System.out.println("Added... " + bookTitle  + " by " + author);
	   }

	   private void loadFromDisk(String bookTitle, String author){
	      System.out.println("Adding..." + bookTitle +" by "+ author);
	   }
}
