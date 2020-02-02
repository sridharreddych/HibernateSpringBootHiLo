package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {         
            bookstoreService.batch1000Authors();
        };
    }
}
/*
 * 
 * How To Generate Sequences Of Identifiers Via Hibernate hi/lo Algorithm

Note: If systems external to your application need to insert rows in your tables then don't rely on hi/lo algorithm since, in such cases, it may cause errors resulted from generating duplicated identifiers. Rely on pooled or pooled-lo algorithms (optimizations of hi/lo).

Description: This is a Spring Boot example of using the hi/lo algorithm for generating 1000 identifiers in 10 database roundtrips for batching 1000 inserts in batches of 30.

Key points:

use the SEQUENCE generator type (e.g., in PostgreSQL)
configure the hi/lo algorithm as in Author.java entity
 */
