package codegym.service;

import codegym.model.Product;

import java.util.ArrayList;

public interface IProductService {

    ArrayList<Product> getAllProduct();

    void save(Product product);

    ArrayList<Product> findByName(String name);

    void update(int id, Product product);

    void delete(int id);

}
