package com.sourceallies.test;

import java.util.Iterator;
import java.util.List;

import com.sourceallies.test.functor.BookPrinter;
import com.sourceallies.test.functor.BooksPrinter;
import com.sourceallies.test.functor.Functor;
import com.sourceallies.test.functor.PriceRiser;
import com.sourceallies.test.model.Book;
import com.sourceallies.test.model.BookCatalog;
import com.sourceallies.test.predicate.PriceLessThanOrEq;
import com.sourceallies.test.predicate.PriceMoreThan;

public class StartApplication {
	public static void main(String args[]) {
		// create list of books
		BookCatalog bookCat = new BookCatalog();
		bookCat.addBook(new Book("book1", "isbn1", "author1", 1));
		bookCat.addBook(new Book("book2", "isbn2", "author2", 2));
		bookCat.addBook(new Book("book3", "isbn3", "author3", 3));
		bookCat.addBook(new Book("book4", "isbn4", "author4", 4));
		bookCat.addBook(new Book("book5", "isbn5", "author5", 5));
		bookCat.addBook(new Book("book6", "isbn6", "author6", 21));
		bookCat.addBook(new Book("book7", "isbn7", "author7", 12));

		// java iterator
		Iterator<Book> javaIter = bookCat.getJavaIterator();
		print("Java Iterator", javaIter);

		// Custom Reverse
		Iterator<Book> customIter = bookCat.getReversIterator();
		print("Revers Iterator", customIter);

		// Price Order Iterator
		bookCat.shuffle();
		Iterator<Book> javaIterAfterShuffle = bookCat.getJavaIterator();
		print("Shufflede data", javaIterAfterShuffle);

		Iterator<Book> priceOrderIterator = bookCat.getPriceOrderIterator();
		print("Price Order Iterator", priceOrderIterator);

		// print with functor
		Functor<List<Book>> printerFunctor = new BooksPrinter<Book>();
		bookCat.executeFunctor(printerFunctor);

		// increase the price of the then exclude the books that has price more
		// than 20
		Iterator<Book> increasePriceAndSelectItements = bookCat.getPriceIncreaseAndFilterIterator(new PriceRiser(10),
				new PriceLessThanOrEq(20));
		print("Price Order Iterator", increasePriceAndSelectItements);

		// Print all books exclude books with price less than 20 using java
		// enhanced iteration
		// don't you think it is like functional language iteration?
		System.out.println("");
		System.out.println("Using the Java Enhaned Iterator to print books more than 20");
		for (Book book : bookCat.getPriceFilterAndPrintIterable(new BookPrinter(), new PriceMoreThan(20)))
			;

	}

	public static void print(String message, Iterator<Book> iterator) {
		System.out.println("");
		System.out.println(message);
		while (iterator.hasNext()) {
			Book book = iterator.next();
			book.print();
		}
	}

}
