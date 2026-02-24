package com.raja.quote_vault.service;

import com.raja.quote_vault.model.Quote;

public interface IQuoteService {

    public String addingQuote(Quote quote);
    public Quote getQuoteById(String id);
}
