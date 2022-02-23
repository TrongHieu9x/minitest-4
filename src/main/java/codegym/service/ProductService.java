package codegym.service;

import codegym.model.Product;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ProductService implements IProductService {
    private ArrayList<Product> products = new ArrayList<>();

    @Override
    public ArrayList<Product> getAllProduct() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public ArrayList<Product> findByName(String name) {
        ArrayList<Product> products1 = new ArrayList<>();
        String regex = ".*" + name + ".*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        for (Product product : products) {
            matcher = pattern.matcher(product.getName());
            if (matcher.find()) {
                products1.add(product);
            }
        }
        return products1;
    }

    @Override
    public void update(int id, Product product) {
        for (Product p : products) {
            if (p.getId() == id) {
                p = product;
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                break;
            }
        }
    }

}
