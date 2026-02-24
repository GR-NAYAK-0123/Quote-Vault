package com.raja.quote_vault.repository;

import com.raja.quote_vault.model.Quote;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IQuoteRepository extends MongoRepository<Quote, String> {
    public List<Quote> findByAuthor(String author);
}
