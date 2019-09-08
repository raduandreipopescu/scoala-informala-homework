package main;

/**
 * General class that keeps the properties of stock items (a product.Product object and the stock quantity).
 *
 * @author Radu Popescu
 */

import product.Product;

public class StockItem {
    private Product product;
    private int quantity;

    public StockItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return ", quantity=" + quantity;
    }
}
