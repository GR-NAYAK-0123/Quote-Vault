package com.raja.quote_vault.service;

import com.raja.quote_vault.model.Quote;

import java.util.List;

public interface IQuoteService {

    public String addingQuote(Quote quote);
    public Quote getQuoteById(String id);
    public List<Quote> getAllQuote();
    public List<Quote> getQuoteByAuthorName(String author);
}
