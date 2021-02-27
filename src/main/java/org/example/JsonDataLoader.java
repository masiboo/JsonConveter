package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.*;

import java.io.IOException;

public class JsonDataLoader {

    private static final String ORDER = "Order";
    private static final String NET_VOLUME = "Net Volume";
    private static final String PRICE = "Price";
    private static final String HOUR = "Hour";

    public QuoteResponse load() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Wrapper wrapper = mapper.readValue(JsonDataProvider.jsonData, Wrapper.class);
        return getResponse(wrapper);
    }

    public QuoteResponse getResponse(Wrapper wrapper) throws JsonProcessingException {
        QuoteResponse returnQuoteResponse = new QuoteResponse();

        for (QuoteRaw quoteRaw : wrapper.getQuotes()) {
            Quote quote = new Quote();
            returnQuoteResponse.getQuotes().add(quote);
            quote.setDate(quoteRaw.getDateApplied());
            QuoteValue quoteValue = new QuoteValue();
            quote.getQuoteValueByHour().add(quoteValue);
            quote.setPersonalInfo(quoteRaw.getPersonalInfo());

            for (QuoteValueRaw quoteValueRaw : quoteRaw.getQuoteValues()) {

                switch (quoteValueRaw.getTLabel()) {
                    case ORDER:
                        quoteValue.setOrder(Integer.parseInt(quoteValueRaw.getValue()));
                        break;
                    case NET_VOLUME:
                        quoteValue.setNetVolume(Double.parseDouble(quoteValueRaw.getValue()));
                        break;
                    case PRICE:
                        quoteValue.setPrice(Double.parseDouble(quoteValueRaw.getValue()));
                        break;
                    case HOUR:
                        quoteValue.setHour(Integer.parseInt(quoteValueRaw.getValue()));
                        break;
                    default:
                        break;
                }
            }
        }
        quoteResponsePrettyPrinter(returnQuoteResponse);
        return returnQuoteResponse;
    }

    void quoteResponsePrettyPrinter(QuoteResponse quoteResponse) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(quoteResponse);
        System.out.println(json);
    }
}
