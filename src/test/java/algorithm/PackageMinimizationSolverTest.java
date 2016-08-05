package algorithm;

import io.FileLoader;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class PackageMinimizationSolverTest {

    PackageMinimizationSolver packageMinimizationSolver;

    @Before
    public void testInitPackage() throws Exception {

        FileLoader fileLoader = new FileLoader();
        try {
            packageMinimizationSolver = fileLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateCenterOut() throws Exception {

        assertTrue(packageMinimizationSolver.getCentersOut().isEmpty());
        packageMinimizationSolver.fulfilled();
        assertFalse(packageMinimizationSolver.getCentersOut().isEmpty());
    }

    @Test
    public void testNumPackageNotZero() throws Exception {

        assertThat(packageMinimizationSolver.getNumPackage(), is(0));
        packageMinimizationSolver.fulfilled();
        assertThat(packageMinimizationSolver.getNumPackage(), not(0));
    }
}
