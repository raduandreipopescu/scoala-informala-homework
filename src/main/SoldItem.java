package main;

/**
 * General class that keeps the properties of sold items (a product.Product object, the sold quantity and the sale date).
 *
 * @author Radu Popescu
 */

import product.Product;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SoldItem {
    private Product product;
    private int soldQuantity;
    private Date saleDate;

    public SoldItem(Product product, int soldQuantity, Date saleDate) {
        this.product = product;
        this.soldQuantity = soldQuantity;
        this.saleDate = saleDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        return "main.SoldItem{" +
                "product=" + product.toString() +
                ", soldQuantity=" + soldQuantity +
                ", saleDate=" + format.format(saleDate) +
                '}';
    }
}
