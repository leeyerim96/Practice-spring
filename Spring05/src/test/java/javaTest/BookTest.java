package javaTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

class Book {
	String title;
	String author;
	int price;
	
	Book(String title, String author, int price){
		this.title= title;
		this.author= author;
		this.price=price;
	}
	
	public boolean isBook(boolean b) {
		return b;
	}
} 

public class BookTest {
	
	public void equalsTest() {
		Book b1 = new Book("죄와벌","톨스토이",10000);
		assertEquals("톨스토이",b1.author);
	}
	
	@Test
	public void sameTest() {
		Book b1 = new Book("죄와벌","톨스토이",10000);
		Book b2 = new Book("전쟁과 평화","톨스토이",15000);
		Book b3 = new Book("전쟁과 평화","톨스토이",15000);
		assertSame(b3,b2);	
	}
	
	public void trueTest() {
		Book b1 = new Book("죄와벌","톨스토이",10000);
		assertTrue(b1.isBook(false));
	}
	
	public void notNulTest() {
		Book b1 = new Book("죄와벌","톨스토이",10000);
		Book b2 = null;
		assertNotNull(b1);
	}
	
	public void arrayEqualsTest() {
		String[] arr1 = new String []{"a,","b","c"};
		String[] arr2 = new String []{"a,","b","c"};
		String[] arr3 = new String []{"a,","c","b"};
		String[] arr4 = new String []{"a,","b1","c1"};
		assertArrayEquals(arr1,arr2);
	}
} // class
