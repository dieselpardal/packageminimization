package io;

import algorithm.PackageMinimizationSolver;
import models.Center;
import models.Product;

public class IOParser {

    private static final String SPACE = " ";

    public void getInput(PackageMinimizationSolver packageMinimizationSolver ) {
        System.out.println("---INPUT ---");
        for (int i = 0; i < packageMinimizationSolver.getCenters().size(); i++) {
            Center center = packageMinimizationSolver.getCenters().get(i);
            System.out.println(center.getCenter() + SPACE + center.getProduct() + SPACE + center.getQuantity());
        }
        for (int i = 0; i < packageMinimizationSolver.getProducts().size(); i++) {
            Product product = packageMinimizationSolver.getProducts().get(i);
            System.out.println(product.getName() + SPACE + product.getQuantity());
        }
    }

    public void getOutput(PackageMinimizationSolver packageMinimizationSolver) {
        System.out.println("--- OUTPUT ---");
        System.out.println(packageMinimizationSolver.getNumPackage());
        for (int i = 0; i < packageMinimizationSolver.getCentersOut().size(); i++) {
            Center centerOut = packageMinimizationSolver.getCentersOut().get(i);
            System.out.println(centerOut.getCenter() + SPACE + centerOut.getProduct() + SPACE + centerOut.getQuantity());
        }
    }
}
