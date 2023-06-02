package com.archproduct.model;

import java.util.List;

public class Response {
    private int total;
    private int skip;
    private int limit;

    private List<ProductPojo> products;

    public Response(int total, int skip, int limit, List<ProductPojo> products) {
        this.total = total;
        this.skip = skip;
        this.limit = limit;
        this.products = products;
    }

    public int getTotal() {
        return total;
    }

    public int getSkip() {
        return skip;
    }

    public int getLimit() {
        return limit;
    }

    public List<ProductPojo> getProducts() {
        return products;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setProducts(List<ProductPojo> products) {
        this.products = products;
    }
}
