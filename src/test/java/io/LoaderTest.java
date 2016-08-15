package io;

import models.Request;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class LoaderTest {

    @Test
    public void testExistFile() throws Exception {

        FileLoader fileLoader = new FileLoader();
        Request request = fileLoader.load("src/test/java/io/pack.txt");
        assertFalse(request.getCenters().isEmpty());
        assertFalse(request.getProducts().isEmpty());
    }
}
