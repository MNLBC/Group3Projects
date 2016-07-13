package com.oocl.mnlbc.cglib;

public class RealBook implements BookFacade {

	private String bookTitle;
	private String author;

	public RealBook(String bookTitle, String author){
	      this.bookTitle = bookTitle;
	      this.author = author;
	      loadFromDisk(bookTitle, author);
	   }

	   public RealBook() {
	}

	public void addBook() {
	  System.out.println("Added... Book title: " + bookTitle + " Author: " + author);
	   }

	 private void loadFromDisk(String bookTitle, String author){
	      System.out.println("Adding... " + bookTitle + " by "+ author);
	   }


	}



