package org.example;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        JsonDataLoader jsonDataLoader = new JsonDataLoader();
        var quoteResponse = jsonDataLoader.load();
        jsonDataLoader.quoteResponsePrettyPrinter(quoteResponse);
    }
}
