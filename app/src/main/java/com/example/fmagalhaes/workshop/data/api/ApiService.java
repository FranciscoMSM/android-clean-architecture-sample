package com.example.fmagalhaes.workshop.data.api;

import com.example.fmagalhaes.workshop.data.models.Movie;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

  @GET("?") Call<ApiGenericResponse<List<Movie>>> getMovies(@Query("s") String query);
}

