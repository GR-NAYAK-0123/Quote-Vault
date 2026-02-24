package com.raja.quote_vault.controller;

import com.raja.quote_vault.model.Quote;
import com.raja.quote_vault.service.IQuoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotes-api")
@RequiredArgsConstructor
public class QuoteController {
    private final IQuoteService quoteService;

    @PostMapping("/publish")
    public ResponseEntity<?> publishQuote(@Valid @RequestBody Quote quote) throws Exception{
        String resultMessage = quoteService.addingQuote(quote);
        return new ResponseEntity<>(resultMessage, HttpStatus.CREATED);
    }

    @GetMapping("/find/Id/{id}")
    public ResponseEntity<?> gettingQuoteById(@PathVariable String id) throws Exception{
        Quote quote = quoteService.getQuoteById(id);
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }

    @GetMapping("/quotes")
    public ResponseEntity<?> gettingAllQuote() throws Exception{
        List<Quote> list = quoteService.getAllQuote();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateOneQuote(@RequestBody Quote quote){
        Quote existingQuote = quoteService.getQuoteById(quote.getId());
        existingQuote.setContent(quote.getContent());
        existingQuote.setAuthor(quote.getAuthor());
        existingQuote.setCategory(quote.getCategory());
        quoteService.addingQuote(quote);
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }

    @GetMapping("/authorName/{author}")
    public ResponseEntity<?> findQuoteByAuthorName(@PathVariable String author) throws Exception{
        List<Quote> list = quoteService.getQuoteByAuthorName(author);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
