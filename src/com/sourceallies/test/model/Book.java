package com.sourceallies.test.model;

public class Book {
	private String title;
	private String isbn;
	private String author;
	private int price;

	public Book(String title, String isbn, String author, int price) {
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
	}

	public void print() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		String data = "[Title =" + title + "] [isbn =" + isbn + "] [author ="
				+ author + "] [price =" + price + "]";
		return data;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getPrice() {
		return price;
	}

	public String getTitle() {
		return title;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

}
