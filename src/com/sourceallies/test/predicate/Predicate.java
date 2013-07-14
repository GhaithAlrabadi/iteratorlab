package com.sourceallies.test.predicate;

/**
 * general interface that used to check for a condition on the Object of class T
 * 
 * @author ghaith
 * 
 * @param <T>
 */
public interface Predicate<T> {
	public boolean check(T t);
}
