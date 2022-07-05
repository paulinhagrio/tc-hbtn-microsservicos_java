package com.example.product.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> list = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return list;
    }

    public Product getProductById(Long id) {
        for (Product product: list) {
            if(product.getId().equals(id)){
                return new Product(product.getId(), product.getCode(), product.getName(), product.getDescription(), product.getPrice(), product.getCreatedOne(), product.getStatus());
            }
        }
        return null;
    }

    public void addProduct(Product s) {
       list.add(s);
    }

    public void updateProduct(Product s) {
        for (Product products: list) {
            if(products.getId().equals(s)){
                list.replaceAll(r -> s);
            }
        }
    }

    public void removeProduct(Product s) {
       list.remove(s);
    }

//    public void addList(List<Product> listOfProducts) {
//        list.add(listOfProducts);
//    }
}
