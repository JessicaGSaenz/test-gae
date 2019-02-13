package com.test.config;

import com.test.dao.BookBeanDAO;
import com.test.data.BookBean;


public class DataBooks {

	BookBeanDAO bookBeanDAO;
	
	public void insertBook() {
		
		BookBean book = new BookBean();
		
		book.setName("El nombre del viento");
		book.setAuthor("Patrick Rothfuss");
		book.setYear(2007);
		book.setGenre("Fantas�a");
		
		bookBeanDAO.save(book);	
		
	}
	
}
