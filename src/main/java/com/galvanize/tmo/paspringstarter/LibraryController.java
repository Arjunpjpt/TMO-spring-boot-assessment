package com.galvanize.tmo.paspringstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.galvanize.tmo.Entity.Book;
import com.galvanize.tmo.Service.LibraryService.ILibraryService;

@RestController
//@CrossOrigin(origin = "*", allowedHeaders="*")
public class LibraryController {

	@Autowired
	private ILibraryService libraryService;
	
    @GetMapping("/health")
    public void health() {

    }
    
/**
 * To save a book
 * @param book
 */
    @PostMapping("/saveBook")
    @ResponseBody
    public Book saveBook(@RequestBody Book book) {
    	System.out.println("Controller");
//    	System.out.println();

    	return libraryService.saveBook(book);
    }
}
