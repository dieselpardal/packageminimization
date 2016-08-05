package io;

import algorithm.PackageMinimizationSolver;
import models.Center;
import models.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
    private static final String DISTRIBUTION_TXT_FILE = "src/main/resources/case3.txt";
    private static final String SPACE = " ";
    private static final int SIZE_CENTERS = 3;
    private static final int SIZE_PRODUCTS = 2;

    public PackageMinimizationSolver load() throws Exception {
        List<Center> centers = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        BufferedReader read;
        String text;
        File file = new File(DISTRIBUTION_TXT_FILE);
        try {
            read = new BufferedReader(new FileReader(file));
            while ((text = read.readLine()) != null) {
                String sub[] = text.split(SPACE);
                if (sub.length == SIZE_CENTERS) {
                     centers.add(new Center(sub[0], sub[1], Integer.parseInt(sub[2])));
                }
                if (sub.length == SIZE_PRODUCTS) {
                     products.add(new Product(sub[0], Integer.parseInt(sub[1])));
                }
            }
        } catch (Exception e) {
            throw new Exception("Não foi possivel carregar o arquivo dos cases.");
        }
        return new PackageMinimizationSolver(centers, products);
    }
}
