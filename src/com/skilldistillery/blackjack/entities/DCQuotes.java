package com.skilldistillery.blackjack.entities;
import java.util.ArrayList;
import java.util.Random;

public class DCQuotes {
    private ArrayList<String> quotes;

    public DCQuotes() {
        quotes = new ArrayList<>();
        quotes.add("I'm Batman.\n- Batman");
        quotes.add("Faster than a speeding bullet.\n- Superman");
        quotes.add("It's not who I am underneath,\nbut what I do that defines me.\n- Batman");
        quotes.add("In brightest day, in blackest\nnight, no evil shall escape my sight.\n- Green Lantern Oath");
        quotes.add("I have nothing to prove to you.\n- Carol Danvers/Captain Marvel");
        quotes.add("Truth and justice always prevail.\n- Wonder Woman");
        quotes.add("To live is to keep moving.\n- The Flash");
        quotes.add("Why do we fall?\nSo we can learn to pick ourselves up.\n- Alfred Pennyworth");
    }


    public String getRandomQuote() {
        Random random = new Random();
        return quotes.get(random.nextInt(quotes.size()));
    }
}
