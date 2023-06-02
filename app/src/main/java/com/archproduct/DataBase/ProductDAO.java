package com.archproduct.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.archproduct.model.ProductPojo;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

@Dao
public interface ProductDAO {
// table name products
    @Query("SELECT * FROM products")
    Observable<List<ProductPojo>> getAllProducts();

    @Insert
    void insertProduct(ProductPojo product);

    @Delete
    void deleteProduct(ProductPojo product);
}
