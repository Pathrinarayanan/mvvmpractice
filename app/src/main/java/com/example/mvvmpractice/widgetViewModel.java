package com.example.mvvmpractice;

// WidgetViewModel.java
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class widgetViewModel extends ViewModel {


    private MutableLiveData<List<WidgetItem>> widgetItems = new MutableLiveData<>();
  public  String API_BASE_URL = "https://run.mocky.io/";

    public LiveData<List<WidgetItem>> getWidgetItems() {
        return widgetItems;
    }

        public void fetchWidgets() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ApiService apiInterface = retrofit.create(ApiService.class);
            Call<WidgetResponse> call = apiInterface.getWidgets();

            call.enqueue(new Callback<WidgetResponse>() {
                @Override
                public void onResponse(Call<WidgetResponse> call, Response<WidgetResponse> response) {
                    if (response.isSuccessful()) {
                        WidgetResponse widgetResponse = response.body();
                        List<WidgetItem> items = widgetResponse.getWidgets();
                        widgetItems.setValue(items); // Update LiveData
                    } else {
                        Log.e("ApiError", "Failed to fetch widgets. Code: " + response.code());
                    }
                }

                @Override
                public void onFailure(Call<WidgetResponse> call, Throwable t) {
                    Log.e("ApiError", "Failed to fetch widgets", t);
                }
            });
        }

}
