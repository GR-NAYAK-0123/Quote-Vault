package com.raja.quote_vault.repository;

import com.raja.quote_vault.model.Quote;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IQuoteRepository extends MongoRepository<Quote, String> {
}
