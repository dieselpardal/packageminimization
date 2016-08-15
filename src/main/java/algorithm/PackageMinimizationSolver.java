package algorithm;


import models.Center;
import models.Product;
import models.Request;
import models.Response;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PackageMinimizationSolver {

    private long countPackages(List<Center> centersOut) {
        return centersOut.stream()
                .map(c -> c.getCenter())
                .distinct()
                .count();
    }

    public Response fulfillOrder(Request request) {
        List<Center> centersOut = new ArrayList<>();
        for (Center center : request.getCenters()) {
            Iterator<Product> iterator = request.getProducts().iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (center.getProduct().equals(product.getName())) {
                    if (product.getQuantity() < center.getQuantity()) {
                        centersOut.add(new Center(center.getCenter(), center.getProduct(), product.getQuantity()));
                        iterator.remove();
                    } else {
                        centersOut.add(new Center(center.getCenter(), center.getProduct(), center.getQuantity()));
                        product.decrementQuantityBy(center.getQuantity());
                        if (product.getQuantity() <= 0) iterator.remove();
                    }
                }
            }
        }
        return new Response(centersOut, (int) countPackages(centersOut));
    }
}
