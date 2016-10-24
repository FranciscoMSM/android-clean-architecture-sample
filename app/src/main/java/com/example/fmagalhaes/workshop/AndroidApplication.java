package com.example.fmagalhaes.workshop;

import android.app.Application;
import com.example.fmagalhaes.workshop.data.api.ApiService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AndroidApplication extends Application {

  public static ApiService apiService;
  private static AndroidApplication myInstance = null;

  @Override public void onCreate() {
    super.onCreate();
    apiService = provideApiService(provideRetrofitBuilder(), provideOkHttpClient(), provideGson());
    myInstance = this;
  }

  public static AndroidApplication getInstance() {
    return myInstance;
  }

  public ApiService getApiService() {
    return apiService;
  }

  public Gson provideGson() {
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
    return gsonBuilder.create();
  }

  public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    return loggingInterceptor;
  }

  public Cache provideHttpCache() {
    int cacheSize = 1024 * 1024 * 10;
    File httpCacheDir = new File(this.getCacheDir(), "http");
    return new Cache(httpCacheDir, cacheSize);
  }

  private OkHttpClient provideOkHttpClient() {
    OkHttpClient.Builder client = new OkHttpClient().newBuilder();
    client.cache(provideHttpCache()).addInterceptor(provideHttpLoggingInterceptor());
    return client.build();
  }

  private Retrofit.Builder provideRetrofitBuilder() {
    return new Retrofit.Builder();
  }

  private ApiService provideApiService(Retrofit.Builder retrofitBuilder, OkHttpClient okHttpClient,
      Gson gson) {

    return retrofitBuilder.addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl("http://www.omdbapi.com/")
        .client(okHttpClient)
        .build()
        .create(ApiService.class);
  }
}
