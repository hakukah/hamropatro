package com.nextnepal.nextNepalPatro.activityNews.model.dto.BBC;

public class BBCDto {
    private String totalResults;

    private ArticlesDto[] articles;

    private String status;

    public String getTotalResults ()
    {
        return totalResults;
    }

    public void setTotalResults (String totalResults)
    {
        this.totalResults = totalResults;
    }

    public ArticlesDto[] getArticles ()
    {
        return articles;
    }

    public void setArticles (ArticlesDto[] articles)
    {
        this.articles = articles;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [totalResults = "+totalResults+", articles = "+articles+", status = "+status+"]";
    }
}
