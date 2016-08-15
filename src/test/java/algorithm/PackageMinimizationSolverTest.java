package algorithm;

import models.Center;
import models.Product;
import models.Request;
import models.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PackageMinimizationSolverTest {

    private List<Center> centers = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    PackageMinimizationSolver solver = new PackageMinimizationSolver();
    Request request;
    Response response;

    private Request createRequest() {
        List<Center> centers = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        centers.add(new Center("Brazil", "Keyboard", 2));
        centers.add(new Center("Brazil", "Mouse", 1));
        centers.add(new Center("Brazil", "Monitor", 1));
        centers.add(new Center("Chile", "Keyboard", 2));
        centers.add(new Center("Chile", "Monitor", 2));
        centers.add(new Center("Panama", "Mouse", 2));
        centers.add(new Center("Argentina", "Monitor", 2));
        products.add(new Product("Keyboard", 3));
        products.add(new Product("Mouse", 1));
        products.add(new Product("Monitor", 2));
        return new Request(centers, products);
    }

    @Test
    public void testGetNumPackageEmpty() throws Exception {
        centers.add(new Center("Brazil", "Keyboard", 2));
        products.add(new Product("Mouse", 2));
        request = new Request(centers, products);
        response = solver.fulfillOrder(request);
        assertThat(response.getNumPackage(), is(0));
    }

    @Test
    public void testGetNumPackageOne() throws Exception {
        centers.add(new Center("Brazil", "Keyboard", 2));
        products.add(new Product("Keyboard", 2));
        request = new Request(centers, products);
        response = solver.fulfillOrder(request);
        assertThat(response.getNumPackage(), is(1));

    }

    @Test
    public void testGetNumPackageTwo() throws Exception {
        centers.add(new Center("Brazil", "Keyboard", 1));
        centers.add(new Center("Chile", "Keyboard", 1));
        products.add(new Product("Keyboard", 2));
        request = new Request(centers, products);
        response = solver.fulfillOrder(request);
        assertThat(response.getNumPackage(), is(2));

    }

    @Test
    public void testGetForFiveCentersExists() throws Exception {
        int num=0;
        request = createRequest();
        response = solver.fulfillOrder(request);
        Iterator<Center> centerOut = response.getCentersOut().iterator();
        while (centerOut.hasNext()) {
            centerOut.next();
            num++;
        }
        assertThat(num, is(5));
    }

    @Test
    public void testCase1() throws Exception {
        centers.add(new Center("Brazil", "Keyboard", 2));
        centers.add(new Center("Brazil", "Mouse", 1));
        centers.add(new Center("Argentina", "Mouse", 2));
        products.add(new Product("Keyboard", 2));
        request = new Request(centers, products);
        response = solver.fulfillOrder(request);
        Iterator<Center> centerIterator = response.getCentersOut().iterator();
        assertThat(response.getNumPackage(), is(1));
        Center centerOut = centerIterator.next();
        assertThat(centerOut.getCenter(), is("Brazil"));
        assertThat(centerOut.getProduct(), is("Keyboard"));
        assertThat(centerOut.getQuantity(), is(2));
    }

    @Test
    public void testCase2() throws Exception {
        centers.add(new Center("Brazil", "Keyboard", 2));
        centers.add(new Center("Brazil", "Mouse", 1));
        centers.add(new Center("Argentina", "Mouse", 2));
        products.add(new Product("Keyboard", 2));
        products.add(new Product("Mouse", 1));
        request = new Request(centers, products);
        response = solver.fulfillOrder(request);
        Iterator<Center> centerIterator = response.getCentersOut().iterator();
        assertThat(response.getNumPackage(), is(1));
        Center centerOut = centerIterator.next();
        assertThat(centerOut.getCenter(), is("Brazil"));
        assertThat(centerOut.getProduct(), is("Keyboard"));
        assertThat(centerOut.getQuantity(), is(2));
        centerOut = centerIterator.next();
        assertThat(centerOut.getCenter(), is("Brazil"));
        assertThat(centerOut.getProduct(), is("Mouse"));
        assertThat(centerOut.getQuantity(), is(1));
    }

    @Test
    public void testCase3() throws Exception {
        request = createRequest();
        response = solver.fulfillOrder(request);
        Iterator<Center> centerIterator = response.getCentersOut().iterator();
        assertThat(response.getNumPackage(), is(2));
        Center centerOut = centerIterator.next();
        assertThat(centerOut.getCenter(), is("Brazil"));
        assertThat(centerOut.getProduct(), is("Keyboard"));
        assertThat(centerOut.getQuantity(), is(2));
        centerOut = centerIterator.next();
        assertThat(centerOut.getCenter(), is("Brazil"));
        assertThat(centerOut.getProduct(), is("Mouse"));
        assertThat(centerOut.getQuantity(), is(1));
        centerOut = centerIterator.next();
        assertThat(centerOut.getCenter(), is("Brazil"));
        assertThat(centerOut.getProduct(), is("Monitor"));
        assertThat(centerOut.getQuantity(), is(1));
        centerOut = centerIterator.next();
        assertThat(centerOut.getCenter(), is("Chile"));
        assertThat(centerOut.getProduct(), is("Keyboard"));
        assertThat(centerOut.getQuantity(), is(1));
        centerOut = centerIterator.next();
        assertThat(centerOut.getCenter(), is("Chile"));
        assertThat(centerOut.getProduct(), is("Monitor"));
        assertThat(centerOut.getQuantity(), is(1));
    }
}
