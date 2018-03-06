package com.ex.pojo;

public class Content {
    private int id;
    private Double price;
    private String title;
    private String pic;
    private String summary;
    private String detail;

    public Content() {

    }

    public Content(int id, Double price, String title, String pic, String summary, String detail) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.pic = pic;
        this.summary = summary;
        this.detail = detail;
    }

    public Content(Double price, String title, String pic, String summary, String detail) {
        this.price = price;
        this.title = title;
        this.pic = pic;
        this.summary = summary;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
