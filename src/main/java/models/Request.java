package models;

import java.util.ArrayList;
import java.util.List;

public class Request {

    private List<Center> centers = new ArrayList<>();
    private List<Product> products = new ArrayList<>();

    public Request(List<Center> centers, List<Product> products) {
        this.centers = centers;
        this.products = products;

    }

    public List<Center> getCenters() {
        return centers;
    }

    public List<Product> getProducts() {
        return products;
    }
}