package com.sourceallies.test.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sourceallies.test.model.Book;

/**
 * Iterator flavor that return reversed order items
 * @author ghaith
 *
 */
public class ReversIterator implements Iterator<Book> {
	List<Book> booksList;
	int index = 0;

	public ReversIterator(List<Book> stabderBooks) {
		if (stabderBooks == null || stabderBooks.isEmpty()) {
			throw new IllegalArgumentException("Array Should not be empty");
		}
		index = 0;
		booksList = new ArrayList<Book>();
		fillReversList(stabderBooks);
	}

	private void fillReversList(List<Book> stabderBooks) {
		for (int i = stabderBooks.size() - 1; i >= 0; i--) {
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
			return book;
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
