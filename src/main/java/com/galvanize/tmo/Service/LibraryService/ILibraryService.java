package com.galvanize.tmo.Service.LibraryService;

import java.util.List;

import com.galvanize.tmo.Entity.Book;

public interface ILibraryService  {
	Book saveBook(Book book) throws Exception;
	List<Book> getBooks() throws Exception;
	void deleteBooks() throws Exception;
}