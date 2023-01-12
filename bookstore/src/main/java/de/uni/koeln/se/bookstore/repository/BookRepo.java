package de.uni.koeln.se.bookstore.repository;

import de.uni.koeln.se.bookstore.datamodel.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
}
