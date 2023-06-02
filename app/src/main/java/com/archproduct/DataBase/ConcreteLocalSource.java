package com.archproduct.DataBase;

import android.content.Context;

import com.archproduct.model.ProductPojo;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class ConcreteLocalSource implements LocalSource{

    private ProductDAO productDAO;
    private static ConcreteLocalSource concreteLocalSource = null;
    private ConcreteLocalSource(Context context){
        productDAO = ProductDatabase.getInstance(context.getApplicationContext()).productDAO();
    }

    public static synchronized ConcreteLocalSource getInstance(Context context){

        if (concreteLocalSource == null){
            concreteLocalSource = new ConcreteLocalSource(context);
        }
        return concreteLocalSource;
    }

    @Override
    public void insert(ProductPojo product) {
        new Thread(){
            public void run(){
                productDAO.insertProduct(product);
            }
        }.start();
    }

    @Override
    public void delete(ProductPojo product) {
        new Thread(){
            public void run(){
                productDAO.deleteProduct(product);
            }
        }.start();
    }


    /*
      @Override
      public LiveData<List<Product>> getCachedProducts() {
      return productDAO.getAllProducts();
          }
   */
    // changing the live Data Into observer
    @Override
    public Observable<List<ProductPojo>> getCachedProducts() {
        return productDAO.getAllProducts();
    }
}
