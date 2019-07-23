package product;

/**
 * General class to keep the common properties of products.
 *
 * @author Radu Popescu
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    private String name;
    private int price;
    private Date validityDate;
    private int weight;
    private int id;

    public Product(String name, int price, Date validityDate, int weight, int id) {
        this.name = name;
        this.price = price;
        this.validityDate = validityDate;
        this.weight = weight;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        return "Id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", validityDate=" + format.format(validityDate) +
                ", weight=" + weight;
    }
}
