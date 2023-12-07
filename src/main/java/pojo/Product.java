package pojo;

import utils.JacksonUtils;

import java.io.IOException;

public class Product {
    private int id;
    private String name;

    public Product() {
    }

    public Product(int id) throws IOException {
        Product[] products = JacksonUtils.deserializeJson("products.json",Product[].class);
        for (Product product : products
             ) {
            if (product.getId() == id){
                this.id = id;
                this.name = product.getName();
            }
        }
        this.id = id;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
