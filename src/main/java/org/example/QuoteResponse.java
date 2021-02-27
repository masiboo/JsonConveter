package org.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.model.Quote;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Setter
@Getter
public class QuoteResponse {
    private final List<Quote> quotes = new ArrayList<>();
}