package com.galvanize.tmo.Repository.LibraryRepository;

import com.galvanize.tmo.Entity.Book;

public interface ILibraryRepository {
	Book saveBook(Book book) throws Exception;

}
