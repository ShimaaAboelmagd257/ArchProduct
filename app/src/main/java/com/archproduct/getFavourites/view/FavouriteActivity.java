package com.archproduct.getFavourites.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.archproduct.getFavourites.presenter.FavouritePresenter;
import com.archproduct.model.ProductsAdapter;
import com.archproduct.DataBase.ConcreteLocalSource;
import com.archproduct.model.ProductPojo;
import com.example.archproduct.R;
import com.archproduct.model.Reposatory;
import com.archproduct.network.ApiClient;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FavouriteActivity extends AppCompatActivity implements ProductsAdapter.OnFavouriteClickListener {

    private final String TAG = "FavouriteActivity";
    List<ProductPojo> productList = new ArrayList<>();
    RecyclerView favouriteList;
    Reposatory repo;
    FavouritePresenter favouritePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        favouriteList = findViewById(R.id.favouriteList);
        favouriteList.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        favouriteList.setLayoutManager(manager);
        ProductsAdapter adapter = new ProductsAdapter(FavouriteActivity.this, productList, FavouriteActivity.this, 1);
        favouriteList.setAdapter(adapter);
        favouritePresenter = new FavouritePresenter(Reposatory.getInstance(ConcreteLocalSource.getInstance(this),
                ApiClient.getInstance(),
                this));

        /*
        * favouritePresenter.getFavourites().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                adapter.setList(products);
            }
        });
 */
        //Rx implemintation
        favouritePresenter.getFavourites().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ProductPojo>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }
                     // set list to the adapter in  onNext() to receive and process items emitted by an Observable
                    @Override
                    public void onNext(@NonNull List<ProductPojo> products) {
                        adapter.setList(products);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    @Override
    public void onClick(ProductPojo product) {
        favouritePresenter.removeProduct(product);
    }
}