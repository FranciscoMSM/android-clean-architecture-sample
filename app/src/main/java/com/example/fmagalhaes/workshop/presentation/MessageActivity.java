package com.example.fmagalhaes.workshop.presentation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.OnClick;
import com.example.fmagalhaes.workshop.AndroidApplication;
import com.example.fmagalhaes.workshop.R;
import com.example.fmagalhaes.workshop.data.api.ApiService;
import com.example.fmagalhaes.workshop.data.models.Movie;
import com.example.fmagalhaes.workshop.presentation.adapters.MovieAdapter;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.util.List;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MessageActivity extends AppCompatActivity implements MessageContract.View {

  private MessagePresenter presenter;
  private RecyclerView mRecyclerView;
  private MovieAdapter mAdapter;
  private EditText mSearchEdit;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    presenter = new MessagePresenter();
    presenter.start(this);
    setContentView(R.layout.activity_main);

    findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        presenter.onButtonClicked(mSearchEdit.getText().toString().trim());
      }
    });

    mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
    mSearchEdit = (EditText) findViewById(R.id.search_edit);

    LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
    mRecyclerView.setLayoutManager(mLayoutManager);

    mAdapter = new MovieAdapter();
    mRecyclerView.setAdapter(mAdapter);
  }

  @Override public void showError(String error) {
    Log.d("Error", error);
  }

  @Override public void showMovieList(List<Movie> movies) {
    mAdapter.setMoviesList(movies);
    mAdapter.notifyDataSetChanged();
  }
}
