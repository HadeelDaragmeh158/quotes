package com.quotes;

public class qouteAuthor {

    String author;
    String text;

    public qouteAuthor(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "{"+
                "author='" + author +
                "', text='" + text +
                '}';
    }
}
