package algorithm;

import models.Center;
import models.Product;

import java.util.ArrayList;
import java.util.List;

public class PackageMinimizationSolver {

    private List<Center> centers;
    private List<Product> products;
    private List<Center> centersOut;
    private int numPackage;

    public List<Center> getCenters() {
        return centers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Center> getCentersOut() {
        return centersOut;
    }

    public int getNumPackage() {
        return numPackage;
    }

    public PackageMinimizationSolver(List<Center> centers, List<Product> products) {
        this.centers = centers;
        this.products = products;
        this.centersOut = new ArrayList<>();
        this.numPackage = 0;
    }

    private int quantPackage() {
        int numPackage = 0;
        if (this.centersOut.size() > 0) {
            numPackage = 1;
            for (int i = 1; i < this.centersOut.size(); i++) {
                if (!this.centersOut.get(i).getCenter().equals(this.centersOut.get(i - 1).getCenter())) {
                    numPackage++;
                }
            }
        }
        return numPackage;
    }

    public void fulfilled() {
        for (int countCenter = 0; countCenter < this.centers.size(); countCenter++) {
            for (int countProduct = 0; countProduct < this.products.size(); countProduct++) {
                Center centers =  this.centers.get(countCenter);
                Product products = this.products.get(countProduct);
                if (centers.getProduct().equals(products.getName())) {
                    if (products.getQuantity() < centers.getQuantity()) {
                        this.centersOut.add(new Center(centers.getCenter(), centers.getProduct(), products.getQuantity()));
                        this.products.remove(countProduct);
                    } else {
                        this.centersOut.add(new Center(centers.getCenter(), centers.getProduct(), centers.getQuantity()));
                        products.decrementQuantityBy(centers.getQuantity());
                        if (products.getQuantity() <= 0) this.products.remove(countProduct);
                    }
                }
            }
        }
        numPackage = quantPackage();
    }
}
