package com.example.demo.BootStrap;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.Entity.Author;
import com.example.demo.Entity.Book;
import com.example.demo.Repositry.AuthorRepositry;
import com.example.demo.Repositry.BookRepositry;
import com.example.demo.Repositry.PublisherRepositry;
@Component
public class JpaCrudBootstrap implements ApplicationListener<ContextRefreshedEvent>{
private AuthorRepositry authorRepositry;
private BookRepositry bookRepositry;
private PublisherRepositry publisherRepositry;

	
	public JpaCrudBootstrap(AuthorRepositry authorRepositry, BookRepositry bookRepositry,
		PublisherRepositry publisherRepositry) {
	super();
	this.authorRepositry = authorRepositry;
	this.bookRepositry = bookRepositry;
	this.publisherRepositry = publisherRepositry;
}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		Author author = new Author("sangamesh", "biradar");
		Book book = new Book(1231,"Inheritance");
		book.authors.add(author);
		author.book.add(book);
		authorRepositry.save(author);	
		bookRepositry.save(book);
		
	}

}
