package com.archproduct.getFavourites.presenter;

import com.archproduct.model.ProductPojo;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public interface FavouriteInterface {
    public Observable<List<ProductPojo>> getFavourites();
    public void removeProduct(ProductPojo product);
}
