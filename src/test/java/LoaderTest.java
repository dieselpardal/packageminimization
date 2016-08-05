import org.junit.Test;

public class LoaderTest {

    @Test
    public void testExistFile() throws Exception {

        Distribution distribution = new Distribution();
        Loader loader = new Loader();
        loader.load(distribution);

    }


}
