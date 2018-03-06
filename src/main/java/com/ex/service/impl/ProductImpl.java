package com.ex.service.impl;

import com.ex.dao.ProductDao;
import com.ex.pojo.Product;
import com.ex.pojo.Transaction;
import com.ex.service.ProductService;
import com.ex.service.TransactionService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


@Service
public class ProductImpl implements ProductService {

    @Resource
    private ProductDao productDao;
    @Resource
    private TransactionService transactionService;

    public List<Product> getProductList() {
        List<Product> productList = productDao.getProductList();
        //设置产品信息 isBuy / isSell
        for (Product product : productList) {
            setProductInfo(transactionService, product);
        }
        return productList;
    }

    public Product getProduct(int id) {
        Product product = productDao.getProduct(id);
        setProductInfo(transactionService, product);
        return product;
    }


    //设置产品信息
    public void setProductInfo(TransactionService transactionService, Product product) {
        Transaction transaction = null;
        if ((transaction = transactionService.getTransaction(product.getId())) != null) {
            product.setIsBuy(true);
            product.setIsSell(true);
            product.setBuyPrice(transaction.getPrice());
            product.setTime(transaction.getTime());
        } else {
            product.setIsBuy(false);
            product.setIsSell(false);
        }
    }


    //根据购买情况获取产品列表 -- 未使用

    @Override
    public List<Product> getProductListIsBuy() {
        List<Product> productList = productDao.getProductList();
        for (Product product : productList) {
            /*
            *  得到已购买清单的商品列表
            *  设置商品信息
            * */
            Transaction transaction = transactionService.getTransaction(product.getId());
            product.setIsBuy(true);
            product.setIsSell(true);
            product.setBuyPrice(transaction.getPrice());
            product.setTime(transaction.getTime());
        }
        return productList;
    }

    @Override
    public List<Product> getProductListIsSell() {
        /*
        *
        * */
        List<Product> productList = productDao.getProductList();
        for (Product product : productList) {
            product.setIsBuy(false);
            product.setIsSell(false);
        }
        return productList;
    }
}
