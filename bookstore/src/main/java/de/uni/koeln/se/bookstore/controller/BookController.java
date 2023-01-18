package de.uni.koeln.se.bookstore.controller;


import de.uni.koeln.se.bookstore.datamodel.Book;
import de.uni.koeln.se.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/bookStore")
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BookController {

    @Autowired
    BookService bookSer;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){

        List<Book> books = new ArrayList<Book>();
        books = bookSer.findBooks();

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {

        return new ResponseEntity<>(bookSer.fetchBook(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        bookSer.addBook(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> removeBookById(@PathVariable int id) {
        Book book = bookSer.fetchBook(id).get();

        if(bookSer.deleteBook(id)){
            return new ResponseEntity<>(book, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(book, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/oldestBook")
    public ResponseEntity<Book> getOldestBook(){
        List<Book> books = new ArrayList<Book>();
        books = bookSer.findBooks();
        if(books.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Book oldestBook = books.get(0);
        for(Book book : books){
            if(book.getYearDate() < oldestBook.getYearDate()){
                oldestBook = book;
            }
        }
        return new ResponseEntity<>(oldestBook, HttpStatus.OK);
    }

    @GetMapping("/newestBook")
    public ResponseEntity<Book> getNewestBook(){
        List<Book> books = new ArrayList<Book>();
        books = bookSer.findBooks();
        if(books.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Book oldestBook = books.get(0);
        for(Book book : books){
            if(book.getYearDate() > oldestBook.getYearDate()){
                oldestBook = book;
            }
        }
        return new ResponseEntity<>(oldestBook, HttpStatus.OK);
    }

}
