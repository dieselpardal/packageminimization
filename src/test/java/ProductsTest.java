import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProductsTest {

    @Test
    public void testSetProducts(){
        Products products = new Products("Tablet", 2);
        assertThat(products.name, is("Tablet"));
        assertThat(products.quantity, is(2));
    }
}
