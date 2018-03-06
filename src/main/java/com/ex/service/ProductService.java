package com.ex.service;

import com.ex.pojo.Product;
import com.ex.pojo.Transaction;
import java.util.List;


public interface ProductService {
    public List<Product> getProductList();


    public List<Product> getProductListIsBuy();

    public List<Product> getProductListIsSell();

    public Product getProduct(int id);

    public void setProductInfo(TransactionService transactionService, Product product);
}
