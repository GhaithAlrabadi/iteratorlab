package com.test.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.test.functor.Functor;
import com.test.model.Book;
import com.test.predicate.Predicate;

/**
 * Iterator flavor that takes list of books and apply a functor operation on an
 * item then check using the predicate if that item will be part of the Iterator next elements.
 * 
 * @author ghaith
 * 
 */
public class PriceIncreaseAndFilter implements Iterator<Book> {

	List<Book> booksList;
	int index = 0;
	private Functor<Book> functor;
	private Predicate<Book> predicate;

	public PriceIncreaseAndFilter(List<Book> books, Functor<Book> functor, Predicate<Book> predicate) {
		if (books == null || books.isEmpty()) {
			throw new IllegalArgumentException("Array Should not be empty");
		}
		index = 0;
		booksList = new ArrayList<Book>();
		fillOrderList(books);
		this.predicate = predicate;
		this.functor = functor;
	}

	private void fillOrderList(List<Book> stabderBooks) {
		for (int i = 0; i < stabderBooks.size(); i++) {
			booksList.add(stabderBooks.get(i));
		}
	}

	@Override
	public boolean hasNext() {
		return index < booksList.size();
	}

	@Override
	public Book next() {
		if (hasNext()) {
			Book book = booksList.get(index);
			index += 1;
			// apply the functor operation
			functor.doYourOperation(book);
			// check if this book adhere the predicate condition
			if (predicate.check(book)) {
				return book;
			} else {
				return this.next();
			}
		}
		return null;
	}

	@Override
	public void remove() {
		if (!booksList.isEmpty()) {
			booksList.remove(index);
			index--;
		} else {
			throw new RuntimeException("Array is Empty");
		}
	}
}
