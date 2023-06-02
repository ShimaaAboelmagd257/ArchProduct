package com.archproduct.network;

import com.archproduct.model.Response;

import io.reactivex.rxjava3.core.Single;



public interface RemoteSource {
    public Single<Response> getProductsFromNetwork();
}
