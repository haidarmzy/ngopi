package com.example.newstoday.NewsCallback;

import java.util.ArrayList;
import java.util.List;

public class NewsCallback {

    private String status;
    private Integer totalResults;
    private ArrayList<articles> articles;

    public String getStatus() {
        return status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public ArrayList<NewsCallback.articles> getArticles() {
        return articles;
    }

    public class articles{
        private ArrayList<source> source;
        private String author;
        private String title;
        private String description;
        private String url;
        private String urlToImage;
        private String publishedAt;

        public ArrayList<NewsCallback.articles.source> getSource() {
            return source;
        }

        public String getAuthor() {
            return author;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getUrl() {
            return url;
        }

        public String getUrlToImage() {
            return urlToImage;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public class source{
            private String id;
            private String name;

            public String getId() {
                return id;
            }

            public String getName() {
                return name;
            }
        }
    }
}
