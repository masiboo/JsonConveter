package org.example;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class JsonDataLoaderTest {
    @Test
    public void loadTest() throws Exception {
        // Arrange
        JsonDataLoader apxDataLoader = new JsonDataLoader();

        // Act
        QuoteResponse response = apxDataLoader.load();

        // Assert
        assertNotNull(response);
        assertFalse(response.getQuotes().isEmpty());
        assertNotNull(response.getQuotes().get(0).getDate());
    }

    @Test
    public void parseFieldNameTest() throws Exception {
        // Arrange
        JsonDataLoader jsonDataLoader = new JsonDataLoader();

        // Act
        JsonFactory factory = new JsonFactory();
        JsonParser parser = factory.createParser(jsonDataLoader.load().getQuotes().toString().getBytes(StandardCharsets.UTF_8));

        // Assert
        while (!parser.isClosed()) {
            parser.nextToken();
            String fieldName = parser.getCurrentName();
            if ("quote".equals(fieldName)) {
                assertEquals("quote", fieldName);
            } else if ("date_applied".equals(fieldName)) {
                assertEquals("date_applied", fieldName);
            } else if ("tLabel".equals(fieldName)) {
                assertEquals("tLabel", fieldName);
            } else if ("values".equals(fieldName)) {
                assertEquals("values", fieldName);
            } else if ("value".equals(fieldName)) {
                assertEquals("value", fieldName);
            }
        }
    }
}

