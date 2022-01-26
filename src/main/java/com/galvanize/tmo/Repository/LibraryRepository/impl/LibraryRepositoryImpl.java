package com.galvanize.tmo.Repository.LibraryRepository.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.galvanize.tmo.Entity.Book;
import com.galvanize.tmo.Repository.LibraryRepository.ILibraryRepository;

@Repository
public class LibraryRepositoryImpl implements ILibraryRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public void deleteBooks() throws Exception {
		String deleteQ = "DELETE  from Book";
		jdbcTemplate.update(deleteQ);
	}

	@Override
	public List<Book> getBooks() throws Exception {
		List<Book> bookList = new ArrayList<Book>();

		try {
			String selectQ = "SELECT * from Book ORDER BY title ASC ";
			SqlRowSet rs = jdbcTemplate.queryForRowSet(selectQ);
			while (rs.next()) {
				Book book = new Book();
				book.setId(Integer.parseInt(rs.getString("id")));
				book.setAuthor(rs.getString("author"));
				book.setTitle(rs.getString("title"));
				book.setYearPublished(Integer.parseInt(rs.getString("yearpublished")));
				bookList.add(book);
			}
			return bookList;
		} catch (Exception e) {

			return bookList;
		}
	}

	@Override
	public Book saveBook(Book book) throws Exception {
		try {

			System.out.println("Repository");
			String insertQ = "insert into book (author, title, yearPublished) values ('" + book.getAuthor() + "', '"
					+ book.getTitle() + "', " + book.getYearPublished() + ")";

			int a = jdbcTemplate.update(insertQ);
			book.setId(0);

			if (a == 1) {
				String selectQ = "SELECT * \n" + "FROM book \n" + "WHERE id = (SELECT MAX(id) FROM book)";
				SqlRowSet rs = jdbcTemplate.queryForRowSet(selectQ);
				while (rs.next()) {
					int id = Integer.parseInt(rs.getString("id"));
					book.setId(id);
				}
				return book;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return book;
	}

}
