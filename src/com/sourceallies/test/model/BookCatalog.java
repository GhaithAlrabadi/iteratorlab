package com.sourceallies.test.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.sourceallies.test.functor.Functor;
import com.sourceallies.test.iterator.PriceFilterAndPrint;
import com.sourceallies.test.iterator.PriceIncreaseAndFilter;
import com.sourceallies.test.iterator.PriceOrderIterator;
import com.sourceallies.test.iterator.ReversIterator;
import com.sourceallies.test.predicate.Predicate;

/**
 * factory for different flavors of Iterator and Iterable
 * 
 * @author ghaith
 * 
 */
public class BookCatalog {
	List<Book> stabderBooks = new ArrayList<Book>();

	public void addBook(Book book) {
		stabderBooks.add(book);
	}

	public Book findBook() {
		return null;
	}

	public void executeFunctor(Functor<List<Book>> booksPrinter) {
		System.out.println("");
		System.out.println("Print using functor");
		booksPrinter.doYourOperation(stabderBooks);
	}

	public void shuffle() {
		Collections.shuffle(stabderBooks);
	}

	public Iterator<Book> getJavaIterator() {
		return stabderBooks.iterator();
	}

	public Iterator<Book> getReversIterator() {
		return new ReversIterator(stabderBooks);
	}

	public Iterator<Book> getPriceOrderIterator() {
		return new PriceOrderIterator(stabderBooks);
	}

	public Iterator<Book> getPriceIncreaseAndFilterIterator(Functor<Book> f, Predicate<Book> p) {
		return new PriceIncreaseAndFilter(stabderBooks, f, p);
	}

	/**
	 * get Iterable version
	 * 
	 * @param f
	 * @param p
	 * @return
	 */
	public Iterable<Book> getPriceFilterAndPrintIterable(Functor<Book> f, Predicate<Book> p) {
		return new PriceFilterAndPrint(stabderBooks, f, p);
	}

}
