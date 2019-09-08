package product;

/**
 * Extension of product.Product class that keeps the particular properties of Vegetal product.Product.
 *
 * @author Radu Popescu
 */

import java.util.Date;

public class VegetalProduct extends Product {

    private String vitamins;

    public VegetalProduct(String name, int price, Date validityDate, int weight, int id, String vitamins) {
        super(name, price, validityDate, weight, id);
        this.vitamins = vitamins;
    }

    public String getVitamins() {
        return vitamins;
    }

    public void setVitamins(String vitamins) {
        this.vitamins = vitamins;
    }

    @Override
    public String toString() {
        return "product.VegetalProduct{" + super.toString() +
                ", vitamins=" + vitamins +
                '}';
    }
}
