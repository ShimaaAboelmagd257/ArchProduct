package com.archproduct.model;

import android.content.Context;

import com.archproduct.network.RemoteSource;
import com.archproduct.DataBase.LocalSource;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class Reposatory implements RepoInterface{

    private Context context;
    RemoteSource remoteSource;
    LocalSource localSource;
    private static Reposatory repo = null;

    public static synchronized Reposatory getInstance(LocalSource localSource , RemoteSource remoteSource , Context context){
        if (repo == null){
            repo = new Reposatory(context , localSource , remoteSource);
        }
        return repo;
    }

    public Reposatory(Context context , LocalSource localSource , RemoteSource remoteSource){
        this.localSource = localSource;
        this.remoteSource =remoteSource;
        this.context =context;
    }


    @Override
    public Observable<List<ProductPojo>> getCachedProducts() {
        return localSource.getCachedProducts();
    }

    @Override
    public void delete(ProductPojo product) {
        localSource.delete(product);
    }

    @Override
    public void insert(ProductPojo product) {
        localSource.insert(product);
    }

    @Override
    public Single<Response> getProductsFromNetwork() {
        return remoteSource.getProductsFromNetwork();
    }


}
