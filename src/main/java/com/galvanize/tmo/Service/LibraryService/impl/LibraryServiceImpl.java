package com.galvanize.tmo.Service.LibraryService.impl;

import org.springframework.stereotype.Service;

import com.galvanize.tmo.Entity.Book;
import com.galvanize.tmo.Repository.LibraryRepository.ILibraryRepository;
import com.galvanize.tmo.Service.LibraryService.ILibraryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LibraryServiceImpl implements ILibraryService {
	@Autowired
	ILibraryRepository libraryRepository;

	@Override
	public Book saveBook(Book book) throws Exception {
		return libraryRepository.saveBook(book);
	}

	@Override
	public List<Book> getBooks() throws Exception {
		return libraryRepository.getBooks();
	}

	@Override
	public void deleteBooks() throws Exception {
		libraryRepository.deleteBooks();
	}
}