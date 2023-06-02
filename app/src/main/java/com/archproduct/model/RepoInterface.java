package com.archproduct.model;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public interface RepoInterface {
    public Observable<List<ProductPojo>> getCachedProducts();
    public void delete(ProductPojo product);
    public void insert(ProductPojo product);
    public Single<Response> getProductsFromNetwork();
}
