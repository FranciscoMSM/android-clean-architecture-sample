package com.example.fmagalhaes.workshop.data.api;

import com.google.gson.annotations.SerializedName;

public class ApiGenericResponse<T> {

  @SerializedName("Search") private T data;

  public ApiGenericResponse(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
