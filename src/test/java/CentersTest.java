import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CentersTest {

    @Test
    public void testSetCenters(){
        Centers centers = new Centers("Brazil", "Tablet", 2);
        assertThat(centers.center, is("Brazil"));
        assertThat(centers.product, is("Tablet"));
        assertThat(centers.quantity, is(2));
    }
}
