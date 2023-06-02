package com.archproduct.DataBase;

import com.archproduct.model.ProductPojo;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public interface LocalSource {
    public void insert(ProductPojo product);
    public void delete(ProductPojo product);
    public Observable<List<ProductPojo>> getCachedProducts();
}
