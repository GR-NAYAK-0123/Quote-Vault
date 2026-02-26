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

    //This method saves the quote in the database
    @Override
    public String addingQuote(Quote quote) {
        quote.setPostingDateTime(LocalDateTime.now());
        String quoteId = quoteRepo.save(quote).getId();
        return "Quote is saved with id : "+quoteId;
    }

    //This method returns the quotes by his id
    @Override
    public Quote getQuoteById(String id) {
        return quoteRepo.findById(id).orElseThrow(() -> new QuoteNotFoundException(id+" Quote doesn't exist"));
    }

    //This method returns all quotes
    @Override
    public List<Quote> getAllQuote() {
        return quoteRepo.findAll();
    }

    //This method gives the quote by author name
    @Override
    public List<Quote> getQuoteByAuthorName(String author) {
        return quoteRepo.findByAuthor(author);
    }

    //This method is basically deletes the quote by his id
    @Override
    public String deleteQuoteById(String id) {
        quoteRepo.deleteById(id);
        return id+" Quote got deleted";
    }
}
