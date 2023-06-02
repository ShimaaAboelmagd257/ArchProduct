package com.archproduct.network;

import com.archproduct.model.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient implements RemoteSource{

    ApiService apiService;
    private static ApiClient apiClient = null;

    private ApiClient() {
        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public static synchronized ApiClient getInstance(){
        if (apiClient == null){
            apiClient = new ApiClient();
        }
        return apiClient;
    }

    private static final String BASE_URL = "https://dummyjson.com/";

    public Single<Response> startCall() {


        return apiService.getAllProducts();



/*        Callback responseCallback = new Callback<Response>(){


            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()){
                    networkDelegator.onSuccessResult(response.body().getallProducts());
                }
            }

            @Override
           public void onFailure(Call<Response> call, Throwable t) {
                networkDelegator.onFailureResult(t.getMessage());
            }
        };


        Call<Response> products = apiService.getAllProducts();

        products.enqueue(responseCallback); */


    }


    @Override
    public Single<Response> getProductsFromNetwork() {
        return ApiClient.getInstance().startCall();
    }
}
