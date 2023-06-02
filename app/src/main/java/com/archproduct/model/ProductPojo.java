package com.archproduct.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "products")
public class ProductPojo {
    @SerializedName("ignored")
    @PrimaryKey(autoGenerate = true)
    public int id = 0;
    private String title;
    private String brand;
    private double price;
    private String description;
    private double rating;
    private String thumbnail;

    public String getTitle() {
        return title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }


    public ProductPojo(String title, String brand, double price, String description, double rating, String thumbnail) {
        this.title = title;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.rating = rating;
        this.thumbnail = thumbnail;
    }


{









}

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}
