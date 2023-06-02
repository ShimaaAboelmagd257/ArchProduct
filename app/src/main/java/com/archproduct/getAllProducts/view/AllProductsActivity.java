package com.archproduct.getAllProducts.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.archproduct.getAllProducts.presenter.AllProductsPresenter;
import com.archproduct.model.ProductsAdapter;
import com.archproduct.DataBase.ConcreteLocalSource;
import com.archproduct.model.ProductPojo;
import com.example.archproduct.R;
import com.archproduct.model.Reposatory;
import com.archproduct.network.ApiClient;

import java.util.ArrayList;
import java.util.List;

public class AllProductsActivity extends AppCompatActivity implements AllProductViewInterface, ProductsAdapter.OnFavouriteClickListener {

    private final String TAG = "MainActivity";
    List<ProductPojo> products = new ArrayList<>();
    RecyclerView productList;
    ProductsAdapter adapter;
    AllProductsPresenter allProductsPresenter;
    Reposatory repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        products = new ArrayList<>();

        productList = findViewById(R.id.productList);
        productList.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        productList.setLayoutManager(manager);
        adapter = new ProductsAdapter(AllProductsActivity.this, products, this, 0);
        productList.setAdapter(adapter);
        allProductsPresenter = new AllProductsPresenter(this,
                Reposatory.getInstance(ConcreteLocalSource.getInstance(this),
                        ApiClient.getInstance(), this));
        allProductsPresenter.getallProducts();
    }

    @Override
    public void onClick(ProductPojo product) {
        addProduct(product);
        Toast.makeText(this, "Added to favourites", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void showData(List<ProductPojo> products) {
        adapter.setList(products);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void addProduct(ProductPojo product) {
        allProductsPresenter.addProduct(product);
    }
}