package com.polarbookshop.catalogservice.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.domain.BookRepository;

@Component
@Profile("testdata")
public class BookDataLoader {

    private final BookRepository bookRepository;

    @Autowired
    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        var book1 = Book.of("1234567891", "Northern Lights",
                "Lyra Silverstar", 9.90);
        var book2 = Book.of("1234567892", "Polar Journey",
                "Iorek Polarson", 12.90);
        bookRepository.save(book1);
        bookRepository.save(book2);
    }

}
