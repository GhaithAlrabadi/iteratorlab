package com.test.predicate;

import com.test.model.Book;

/**
 * Check if book price is less than or equal a passed amount
 * @author ghaith
 *
 */
public class PriceLessThanOrEq implements Predicate<Book> {

	private int minPrice;

	public PriceLessThanOrEq(int minPrice) {
		this.minPrice = minPrice;
	}

	@Override
	public boolean check(Book t) {
		if (t != null) {
			return t.getPrice() <= this.minPrice;
		}
		return false;
	}

}
