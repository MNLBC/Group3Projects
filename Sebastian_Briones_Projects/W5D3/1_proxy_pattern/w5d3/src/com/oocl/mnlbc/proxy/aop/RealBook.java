package com.oocl.mnlbc.proxy.aop;

public class RealBook implements BookFacade {

	private String author;

	public RealBook(String author) {
		this.author = author;

	}

	public void showAuthor() {
		System.out.println("This book is written by:" + this.author);
	}

}
