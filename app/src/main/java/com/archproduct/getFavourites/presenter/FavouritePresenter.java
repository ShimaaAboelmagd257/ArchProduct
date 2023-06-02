package com.archproduct.getFavourites.presenter;

import com.archproduct.model.ProductPojo;
import com.archproduct.model.RepoInterface;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class FavouritePresenter implements FavouriteInterface{

    private RepoInterface repoInterface;

    public FavouritePresenter(RepoInterface repoInterface){
        this.repoInterface =repoInterface;
    }

    @Override
    public Observable<List<ProductPojo>> getFavourites() {
        return repoInterface.getCachedProducts();
    }

    @Override
    public void removeProduct(ProductPojo product) {
        repoInterface.delete(product);
    }
}
