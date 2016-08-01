import java.util.ArrayList;
import java.util.List;

public class Distribution {

    private static final String SPACE = " ";
    private List<Centers> centers;
    private List<Products> product;
    private List<Centers> centersOut;
    private int numPackage;

    public Distribution() {
        this.centers = new ArrayList<>();
        this.product = new ArrayList<>();
        this.centersOut = new ArrayList<>();
        this.numPackage = 0;
    }

    public void setCenter(String sub[]) {
        this.centers.add(new Centers(sub[0], sub[1], Integer.parseInt(sub[2])));
    }

    public void setProduct(String sub[]) {
        this.product.add(new Products(sub[0], Integer.parseInt(sub[1])));
    }

    public void getInput() {
        System.out.println("---INPUT ---");
        for (int i = 0; i < this.centers.size(); i++) {
            System.out.println(this.centers.get(i).center + SPACE + this.centers.get(i).product + SPACE + this.centers.get(i).quantity);
        }
        for (int i = 0; i < this.product.size(); i++) {
            System.out.println(this.product.get(i).name + SPACE + this.product.get(i).quantity);
        }
    }

    public void getOutput() {
        System.out.println("--- OUTPUT ---");
        System.out.println(numPackage);
        for (int i = 0; i < this.centersOut.size(); i++) {
            System.out.println(this.centersOut.get(i).center + SPACE + this.centersOut.get(i).product + SPACE + this.centersOut.get(i).quantity);
        }
    }

    public void fulfilled() {
        for (int countCenter = 0; countCenter < this.centers.size(); countCenter++) {
            for (int countProduct = 0; countProduct < this.product.size(); countProduct++) {
                Centers cen =  this.centers.get(countCenter);
                Products pro = this.product.get(countProduct);
                if (cen.product.equals(pro.name)) {
                    if (pro.quantity < cen.quantity) {
                        this.centersOut.add(new Centers(cen.center, cen.product, pro.quantity));
                        this.product.remove(countProduct);
                    } else {
                        this.centersOut.add(new Centers(cen.center, cen.product, cen.quantity));
                        pro.quantity -= cen.quantity;
                        if (pro.quantity <= 0) this.product.remove(countProduct);
                    }
                }
            }
        }
        if (this.centersOut.size() > 0) {
            numPackage = 1;
            for (int i = 1; i < this.centersOut.size(); i++) {
                if (!this.centersOut.get(i).center.equals(this.centersOut.get(i - 1).center)) {
                    numPackage++;
                }
            }
        }
    }
}
