package com.example.fmagalhaes.workshop.domain;

import com.example.fmagalhaes.workshop.AndroidApplication;
import com.example.fmagalhaes.workshop.data.api.ApiGenericResponse;
import com.example.fmagalhaes.workshop.data.api.ApiService;
import com.example.fmagalhaes.workshop.data.models.Movie;
import java.util.List;
import retrofit2.Call;
import retrofit2.Response;

public class MessageInteractor {

  public interface Callback {
    void onSuccess(List<Movie> movies);

    void onError(String error);
  }

  private ApiService apiService;

  public MessageInteractor() {
    this.apiService = AndroidApplication.getInstance().getApiService();
  }

  public void get(final Callback callback, String query) {
    final Call<ApiGenericResponse<List<Movie>>> call = apiService.getMovies(query);

    call.enqueue(new retrofit2.Callback<ApiGenericResponse<List<Movie>>>() {
      @Override public void onResponse(Call<ApiGenericResponse<List<Movie>>> call,
          Response<ApiGenericResponse<List<Movie>>> response) {
        callback.onSuccess(response.body().getData());
      }

      @Override public void onFailure(Call<ApiGenericResponse<List<Movie>>> call, Throwable t) {
        callback.onError("Falhou");
      }
    });
  }
}
