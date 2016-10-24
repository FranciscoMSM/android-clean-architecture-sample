package com.example.fmagalhaes.workshop.data.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Movie implements Serializable {

  @SerializedName("Year") private String year;
  @SerializedName("Title") private String title;
  @SerializedName("Poster") private String posterUrl;

  public Movie(String year, String title, String posterUrl) {
    this.year = year;
    this.title = title;
    this.posterUrl = posterUrl;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPosterUrl() {
    return posterUrl;
  }

  public void setPosterUrl(String posterUrl) {
    this.posterUrl = posterUrl;
  }
}
