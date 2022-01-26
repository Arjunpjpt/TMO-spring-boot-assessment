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
			
			//
//			try {
//			 Statement stmt = dataSource.getConnection().createStatement();
//		       
//		        ResultSet rss = stmt.executeQuery("Select * from book");
//		        while (rss.next()) {
//		            System.out.println("Read from DB: " + rss.getString("title"));
//		        }
//			
//			}catch (Exception e) {
//				System.out.println("Error --1- repo");
//				System.out.println(e);
//			}
			//
			
			
			System.out.println("Repository");
			String selectQ = "Select * from book";
			SqlRowSet rs = jdbcTemplate.queryForRowSet(selectQ);
			
			while(rs.next()){
				
				System.out.println("========"+rs.getString("title"));
				
			}
}catch (Exception e) {
			System.out.println("Error --- repo");
			System.out.println(e);
		}
		return book;
	}
	
}
