package com.archproduct.getAllProducts.presenter;

import com.archproduct.getAllProducts.view.AllProductViewInterface;
import com.archproduct.model.ProductPojo;
import com.archproduct.model.RepoInterface;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AllProductsPresenter implements AllProductsPresenterInterface {

    private AllProductViewInterface view;
    private RepoInterface repoInterface;

    public AllProductsPresenter(AllProductViewInterface view, RepoInterface repoInterface) {
        this.view = view;
        this.repoInterface = repoInterface;
    }
/*
    @Override
  public void onSuccessResult(List<Product> products) {view.showData(products);
   }

    @Override
   public void onFailureResult(String errorMessage) {
    }*/


    //Rx implemintation

    @Override
    public void getallProducts() {
        repoInterface.getProductsFromNetwork()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            view.showData(response.getProducts());
                        }, throwable -> {
                            // Handle error


                        }
                );
    }

    @Override
    public void addProduct(ProductPojo product) {
        repoInterface.insert(product);
    }
}
