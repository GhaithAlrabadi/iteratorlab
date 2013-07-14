package com.sourceallies.test.predicate;

import com.sourceallies.test.model.Book;
/**
 * Check if book price is more than a passed amount
 * @author ghaith
 *
 */
public class PriceMoreThan implements Predicate<Book> {

	private int minPrice;

	public PriceMoreThan(int minPrice) {
		this.minPrice = minPrice;
	}

	@Override
	public boolean check(Book t) {
		if (t != null) {
			return t.getPrice() > this.minPrice;
		}
		return false;
	}

}
