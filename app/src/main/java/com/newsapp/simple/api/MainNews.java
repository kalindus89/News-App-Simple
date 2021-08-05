package com.newsapp.simple.api;

import java.util.List;

public class MainNews {


    private String status;
    private String totalResults;
    private List<ModelClass> articles;

    public MainNews(String status, String totalResults, List<ModelClass> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public List<ModelClass> getArticles() {
        return articles;
    }
}
