package com.sourceallies.test.functor;

import com.sourceallies.test.model.Book;

/**
 * Functor implementation that oparate on a Book class by increasing it with
 * amount passed in the constructor
 * 
 * @author ghaith
 * 
 */
public class PriceRiser implements Functor<Book> {

	private int increase;

	public PriceRiser(int increase) {
		this.increase = increase;
	}

	@Override
	public void doYourOperation(Book t) {
		t.setPrice(t.getPrice() + increase);
	}

}
