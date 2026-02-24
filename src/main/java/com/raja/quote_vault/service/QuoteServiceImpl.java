package com.raja.quote_vault.service;

import com.raja.quote_vault.exception.QuoteNotFoundException;
import com.raja.quote_vault.model.Quote;
import com.raja.quote_vault.repository.IQuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements IQuoteService{

    private final IQuoteRepository quoteRepo;

    @Override
    public String addingQuote(Quote quote) {
        quote.setPostingDateTime(LocalDateTime.now());
        String quoteId = quoteRepo.save(quote).getId();
        return "Quote is saved with id : "+quoteId;
    }

    @Override
    public Quote getQuoteById(String id) {
        return quoteRepo.findById(id).orElseThrow(() -> new QuoteNotFoundException(id+" Quote doesn't exist"));
    }
}
