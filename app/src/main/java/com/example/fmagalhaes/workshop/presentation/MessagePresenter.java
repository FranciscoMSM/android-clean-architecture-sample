package com.example.fmagalhaes.workshop.presentation;

import com.example.fmagalhaes.workshop.data.api.ApiService;
import com.example.fmagalhaes.workshop.data.models.Movie;
import com.example.fmagalhaes.workshop.domain.MessageInteractor;
import java.util.List;

public class MessagePresenter implements MessageContract.Presenter {

  private MessageContract.View view;
  private MessageInteractor getMessage;

  public MessagePresenter() {
    getMessage = new MessageInteractor();
  }

  @Override public void start(MessageContract.View view) {
    this.view = view;
  }

  @Override public void onButtonClicked(String query) {
    getMessage.get(new GetMovieListCallback(), query);
  }

  private class GetMovieListCallback implements MessageInteractor.Callback {
    @Override public void onSuccess(List<Movie> movies) {
      view.showMovieList(movies);
    }

    @Override public void onError(String error) {
      view.showError(error);
    }
  }
}
