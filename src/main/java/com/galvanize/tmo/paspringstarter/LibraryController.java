package com.galvanize.tmo.paspringstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ResponseBody
    public String health() {
    	return "Healthy";
    }
    
/**
 * To save a book
 * @param book
 */
    @PostMapping("/books")
    @ResponseBody
    public ResponseEntity<?> saveBook(@RequestBody Book book)  {
    	System.out.println("Controller");
//    	System.out.println();

    	try {
    		Book bookR = libraryService.saveBook(book);
			if(bookR.getId()>0) {
				return new ResponseEntity<>(bookR, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return new ResponseEntity<>(book, HttpStatus.BAD_REQUEST);
    }
}
