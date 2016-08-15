package models;

import java.util.ArrayList;
import java.util.List;

public class Response {

    private List<Center> centersOut = new ArrayList<>();
    private int numPackage;

    public Response(List<Center> centersOut, int numPackage) {
        this.centersOut = centersOut;
        this.numPackage = numPackage;

    }

    public List<Center> getCentersOut() {
        return this.centersOut;
    }

    public int getNumPackage() {
        return this.numPackage;
    }
}

