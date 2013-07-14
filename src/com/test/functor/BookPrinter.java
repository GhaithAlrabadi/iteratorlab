package com.test.functor;

import com.test.model.Book;
/**
 * class that print one book element at a time
 * @author ghaith
 *
 */
public class BookPrinter implements Functor<Book> {

	@Override
	public void doYourOperation(Book t) {
		t.print();

	}

}
