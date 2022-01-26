package com.galvanize.tmo.Repository.LibraryRepository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.galvanize.tmo.Entity.Book;
import com.galvanize.tmo.Repository.LibraryRepository.ILibraryRepository;

@Repository
public class LibraryRepositoryImpl implements ILibraryRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	 @Autowired
	    private DataSource dataSource;
	 
	@Override
	public Book saveBook(Book book) throws Exception {
		try {
			

			
			
			System.out.println("Repository");
			String insertQ = "insert into book (author, title, yearPublished) values ('"+book.getAuthor()+"', '"+book.getTitle()+"', "+book.getYearPublished()+")";

			int a =jdbcTemplate.update(insertQ);
			book.setId(0);

			if(a==1) {
				String selectQ = "SELECT * \n" + 
						"FROM book \n" + 
						"WHERE id = (SELECT MAX(id) FROM book)";
				SqlRowSet rs=jdbcTemplate.queryForRowSet(selectQ);
				while(rs.next()) {
					int id = Integer.parseInt(rs.getString("id"));
					book.setId(id);
				}
				return book;
			}
			System.out.println("====="+a);
}catch (Exception e) {
			System.out.println("Error --- repo");
			System.out.println(e);
		}
		return book;
	}
	
}
