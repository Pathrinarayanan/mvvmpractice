package com.example.mvvmpractice;

// ApiService.java
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("v3/06780b47-23b7-4218-829b-7e5b7ed30fb3")
    Call<WidgetResponse> getWidgets();
}
