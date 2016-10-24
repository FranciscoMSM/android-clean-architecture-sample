package com.example.fmagalhaes.workshop.presentation;

import com.example.fmagalhaes.workshop.data.models.Movie;
import java.util.List;

public interface MessageContract {
  interface View {
    void showError(String error);
    void showMovieList(List<Movie> movies);
  }

  interface Presenter {
    void start(View view);
    void onButtonClicked(String query);
  }
}
