package com.test.functor;

/**
 * general interface that will be implemented later to apply one operation on a
 * T object
 * 
 * @author ghaith
 * 
 * @param <T>
 */
public interface Functor<T> {
	public void doYourOperation(T t);
}
