package com.raja.quote_vault.service;

import com.raja.quote_vault.exception.QuoteNotFoundException;
import com.raja.quote_vault.model.Quote;
import com.raja.quote_vault.repository.IQuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    @Override
    public List<Quote> getAllQuote() {
        return quoteRepo.findAll();
    }

    @Override
    public List<Quote> getQuoteByAuthorName(String author) {
        return quoteRepo.findByAuthor(author);
    }

    @Override
    public String deleteQuoteById(String id) {
        quoteRepo.deleteById(id);
        return id+" Quote got deleted";
    }
}
