package com.galvanize.tmo.paspringstarter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.galvanize.tmo.Entity.Book;
import com.galvanize.tmo.Service.LibraryService.ILibraryService;

@RestController
//@CrossOrigin(origin = "*", allowedHeaders="*")
@RequestMapping(value="/api")
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
	 * 
	 * @param book
	 */
	@PostMapping("/books")
	@ResponseBody
	public ResponseEntity<?> saveBook(@RequestBody Book book) {


		try {
			Book bookR = libraryService.saveBook(book);
			if (bookR.getId() > 0) {
				return new ResponseEntity<>(bookR, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return new ResponseEntity<>(book, HttpStatus.BAD_REQUEST);
	}

	/**
	 * To return array of books
	 * 
	 * @param
	 */
	@GetMapping("/books")
	@ResponseBody
	public ResponseEntity<?> getBooks() {

		try {
			HashMap<String, List> hm =new HashMap<>();
			hm.put("books", libraryService.getBooks());
			return new ResponseEntity<>(hm, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>( HttpStatus.BAD_REQUEST);

	}

	/**
	 * Delete all books
	 * 
	 * @param
	 */
	@DeleteMapping("/books")
	@ResponseBody
	public ResponseEntity<?> deleteBooks() {

		try {
			libraryService.deleteBooks();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}
}
