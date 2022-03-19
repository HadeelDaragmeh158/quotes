package com.quotes;

public class QuotesAPI {
    private String quoteText ;
    private String quoteAuthor;

    public QuotesAPI(String quoteText, String quoteAuthor) {
        this.quoteText = quoteText;
        this.quoteAuthor = quoteAuthor;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public void setQuoteAuthor(String quoteAuthor) {
        this.quoteAuthor = quoteAuthor;
    }

    @Override
    public String toString() {
        return "QuotesAPI{" +
                "quoteText='" + quoteText + '\'' +
                ", quoteAuthor='" + quoteAuthor + '\'' +
                '}';
    }
}
