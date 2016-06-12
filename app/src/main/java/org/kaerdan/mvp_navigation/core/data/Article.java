package org.kaerdan.mvp_navigation.core.data;

public class Article {
    private final int id;
    private final String title;
    private final String body;
    private final boolean isFavourite;

    public Article(int id, String title, String body, boolean isFavourite) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.isFavourite = isFavourite;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public boolean isFavourite() {
        return isFavourite;
    }
}
