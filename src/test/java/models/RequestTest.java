package models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RequestTest {

    private List<Center> centers = new ArrayList<>();
    private List<Product> products = new ArrayList<>();

    @Test
    public void testNewRequest() {
        centers.add(new Center("Brazil", "Keyboard", 2));
        products.add(new Product("Keyboard", 2));
        Request request = new Request(centers, products);
        Center center = request.getCenters().get(0);
        Product product = request.getProducts().get(0);
        assertThat(center.getCenter(), is("Brazil"));
        assertThat(center.getProduct(), is("Keyboard"));
        assertThat(center.getQuantity(), is(2));
        assertThat(product.getName(), is("Keyboard"));
        assertThat(product.getQuantity(), is(2));
    }

}
