package com.quotes;

public class qouteAuthor {

    String author;
    String likes;
    String test;

    public qouteAuthor(String auther , String likes , String test) {
    this.author=auther;
    this.likes=likes;
    this.test=test;
    }

    public String getAuthor() {
        return author;
    }

    public String getTest() {
        return test;
    }

    @Override
    public String toString() {
        return "Qoute{" +
                "author='" + author + '\'' +
                ", likes='" + likes + '\'' +
                ", test='" + test + '\'' +
                '}';
    }
}
