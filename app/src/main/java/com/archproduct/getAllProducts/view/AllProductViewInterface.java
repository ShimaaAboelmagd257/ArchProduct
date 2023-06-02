package com.archproduct.getAllProducts.view;

import com.archproduct.model.ProductPojo;

import java.util.List;

public interface AllProductViewInterface {
    public void showData(List<ProductPojo> products);
    public void addProduct(ProductPojo product);

}
