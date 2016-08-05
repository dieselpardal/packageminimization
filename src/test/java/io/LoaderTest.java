package io;

import algorithm.PackageMinimizationSolver;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class LoaderTest {

    @Test
    public void testExistFile() throws Exception {

        PackageMinimizationSolver packageMinimizationSolver;
        FileLoader fileLoader = new FileLoader();
        packageMinimizationSolver = fileLoader.load();
        assertFalse(packageMinimizationSolver.getCenters().isEmpty());
        assertFalse(packageMinimizationSolver.getProducts().isEmpty());
    }


}
