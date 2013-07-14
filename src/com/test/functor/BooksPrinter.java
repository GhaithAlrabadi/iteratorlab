package com.test.functor;

import java.util.List;

/**
 * class that takes list of books and print all of them, this shows how flexible
 * is the functor
 * 
 * @author ghaith
 * 
 * @param <E>
 */
public class BooksPrinter<E> implements Functor<List<E>> {

	@Override
	public void doYourOperation(List<E> t) {
		for (E temp : t) {
			print(temp);
		}
	}

	private void print(E temp) {
		System.out.println(temp);
	}

}
