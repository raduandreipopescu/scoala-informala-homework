package product;

/**
 * Extension of product.Product class that keeps the particular properties of Animal product.Product.
 *
 * @author Radu Popescu
 */

import java.util.Date;

public class AnimalProduct extends Product {

    private int storageTemperature;

    public AnimalProduct(String name, int price, Date validityDate, int weight, int id, int storageTemperature) {
        super(name, price, validityDate, weight, id);
        this.storageTemperature = storageTemperature;
    }

    public int getStorageTemperature() {
        return storageTemperature;
    }

    public void setStorageTemperature(int storageTemperature) {
        this.storageTemperature = storageTemperature;
    }

    @Override
    public String toString() {
        return "product.AnimalProduct{" + super.toString() +
                ", storageTemperature=" + storageTemperature +
                '}';
    }
}
