package models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ResponseTest {

    @Test
    public void testNewResponse() {
        List<Center> centersOut = new ArrayList<>();
        int numPackage;
        centersOut.add(new Center("Brazil", "Keyboard", 2));
        numPackage = 1;
        Response response = new Response(centersOut, numPackage);
        assertThat(response.getCentersOut().get(0).getCenter(), is("Brazil"));
        assertThat(response.getCentersOut().get(0).getProduct(), is("Keyboard"));
        assertThat(response.getCentersOut().get(0).getQuantity(), is(2));
        assertThat(response.getNumPackage(), is(1));
    }
}
