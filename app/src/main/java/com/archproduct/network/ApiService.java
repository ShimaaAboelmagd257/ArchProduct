package com.archproduct.network;



import com.archproduct.model.Response;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;



public interface ApiService {
    //the Single data type represents an observable stream that emits a single value
    /* the calling thread is not blocked
    single  is  used when making network requests or
    other asynchronous operations
     */
    //When a Call is executed, it blocks the calling thread until the response is received but using single resolve this issue
    /*
    Call<Response> getAllProducts();
    */
    @GET("products")
    Single<Response> getAllProducts();

}
