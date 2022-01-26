package com.galvanize.tmo.Service.LibraryService.impl;

import org.springframework.stereotype.Service;

import com.galvanize.tmo.Entity.Book;
import com.galvanize.tmo.Repository.LibraryRepository.ILibraryRepository;
import com.galvanize.tmo.Service.LibraryService.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


@Service
public class LibraryServiceImpl implements ILibraryService {
	@Autowired
	ILibraryRepository libraryRepository;
	
	
	
	@Override
	public Book saveBook(Book book) throws Exception {
		System.out.println("Service");
		return libraryRepository.saveBook(book);
	}
}