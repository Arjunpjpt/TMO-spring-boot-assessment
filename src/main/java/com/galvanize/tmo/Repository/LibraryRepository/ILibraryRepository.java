package com.galvanize.tmo.Repository.LibraryRepository;

import java.util.List;

import com.galvanize.tmo.Entity.Book;

public interface ILibraryRepository {
	Book saveBook(Book book) throws Exception;
	List<Book> getBooks() throws Exception;
	void deleteBooks() throws Exception;


}
