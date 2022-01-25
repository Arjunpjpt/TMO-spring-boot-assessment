package com.galvanize.tmo.Service.LibraryService.impl;

import org.springframework.stereotype.Service;

import com.galvanize.tmo.Entity.Book;
import com.galvanize.tmo.Service.LibraryService.ILibraryService;

@Service
public class LibraryServiceImpl implements ILibraryService {
	public Book saveBook(Book book) {
		System.out.println("Service");
		return book;
	}
}