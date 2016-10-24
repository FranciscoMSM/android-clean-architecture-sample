package com.example.fmagalhaes.workshop.presentation.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.fmagalhaes.workshop.R;
import com.example.fmagalhaes.workshop.data.models.Movie;
import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter {

  private List<Movie> moviesList;

  public MovieAdapter() {
    this.moviesList = new ArrayList<>();
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.movie_layout_list_row, parent, false);
    return new MovieViewHolder(view);
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    Movie movie = moviesList.get(position);
    ((MovieViewHolder) holder).bind(movie);
  }

  @Override public int getItemCount() {
    return moviesList.size();
  }

  public void setMoviesList(List<Movie> moviesList) {
    this.moviesList = moviesList;
  }


}
