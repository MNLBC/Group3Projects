package com.oocl.mnlbc.proxy.three;

public class RealBook implements BookFacade {
	private String title;
	private String author;

	public RealBook(String title, String author) {
		this.title = title;
		this.author = author;
		addBook();
	}

	@Override
	public void addBook() {
		System.out.println("Successfully added " + title + " by " + author);

	}

}
