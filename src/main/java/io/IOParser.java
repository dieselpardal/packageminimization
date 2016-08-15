package io;

import models.Response;

public class IOParser {

    private static final String SPACE = " ";

    public void print(Response response) {
        System.out.println("--- OUTPUT ---");
        System.out.println(response.getNumPackage());
        response.getCentersOut()
                .forEach(n -> System.out.println(n.getCenter() + SPACE + n.getProduct() + SPACE + n.getQuantity()));
    }
}
