package com.sourceallies.test.iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.sourceallies.test.model.Book;
/**
 * Iterator flavor that return sorted items by price amount ascending
 * @author ghaith
 *
 */
public class PriceOrderIterator implements Iterator<Book> {

	List<Book> booksList;
	int index = 0;

	public PriceOrderIterator(List<Book> stabderBooks) {
		if (stabderBooks == null || stabderBooks.isEmpty()) {
			throw new IllegalArgumentException("Array Should not be empty");
		}
		index = 0;
		booksList = new ArrayList<Book>();
		fillOrderList(stabderBooks);
	}

	private void fillOrderList(List<Book> stabderBooks) {
		for (int i = 0; i < stabderBooks.size(); i++) {
			booksList.add(stabderBooks.get(i));
		}
		// create comparator that will be used to compare the objects
		Comparator<Book> priceComparator = new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				return o1.getPrice() - o2.getPrice();
			}
		};
		Collections.sort(booksList, priceComparator);

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
