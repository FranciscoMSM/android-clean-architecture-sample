package com.example.fmagalhaes.workshop.presentation.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.fmagalhaes.workshop.R;
import com.example.fmagalhaes.workshop.data.models.Movie;
import com.squareup.picasso.Picasso;
import org.w3c.dom.Text;

public class MovieViewHolder extends RecyclerView.ViewHolder {

  private TextView title;
  private TextView year;
  private ImageView poster;

  public MovieViewHolder(View view) {
    super(view);

    title = (TextView) view.findViewById(R.id.title);
    year = (TextView) view.findViewById(R.id.year);
    poster = (ImageView) view.findViewById(R.id.poster);
  }

  public void bind(Movie movie) {
    title.setText(movie.getTitle());
    year.setText(movie.getYear() + "");

    Picasso.with(itemView.getContext()).load(movie.getPosterUrl()).into(poster);
  }
}
