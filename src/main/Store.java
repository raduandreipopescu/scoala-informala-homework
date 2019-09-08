package main;

/**
 * General class that keeps actions of the store
 *
 * @author Radu Popescu
 */

import product.AnimalProduct;
import product.Product;
import product.VegetalProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Store {
    private final String[] animalProductNames = new String[]{"milk", "eggs", "cheese", "yogurt", "sour cream"};
    public List stockItemList = new ArrayList();
    public List soldItemList = new ArrayList();

    public int readInt(String intMessageRequest) {
        Scanner sc = new Scanner(System.in);
        System.out.println(intMessageRequest);
        int value = sc.nextInt();
        return value;
    }

    public String readString(String stringMessageRequest) {
        Scanner sc = new Scanner(System.in);
        System.out.println(stringMessageRequest);
        String text = sc.nextLine();
        return text;
    }

    public Product addProduct(String name, int price, String date, int weight) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date validityDate = format.parse(date);

        int id = stockItemList.size() + 1;

        return new Product(name, price, validityDate, weight, id);
    }

    public void addAnimalProduct(String name, int price, String date, int weight, int storageTemperature, int quantity) throws ParseException {

        if (Arrays.asList(animalProductNames).contains(name)) {

            Product tmpProduct = addProduct(name, price, date, weight);

            AnimalProduct tmpAnimalProduct = new AnimalProduct(tmpProduct.getName(), tmpProduct.getPrice(),
                    tmpProduct.getValidityDate(), tmpProduct.getWeight(), tmpProduct.getId(), storageTemperature);

            StockItem tmpStockItem = new StockItem(tmpAnimalProduct, quantity);
            stockItemList.add(tmpStockItem);
        } else {
            System.out.println("Item is not on the list");
        }
    }

    public void addVegetalProduct(String name, int price, String date, int weight, String vitamins, int quantity) throws ParseException {

        Product tmpProduct = addProduct(name, price, date, weight);

        VegetalProduct tmpVegetalProduct = new VegetalProduct(tmpProduct.getName(), tmpProduct.getPrice(),
                tmpProduct.getValidityDate(), tmpProduct.getWeight(), tmpProduct.getId(), vitamins);

        StockItem tmpStockItem = new StockItem(tmpVegetalProduct, quantity);
        stockItemList.add(tmpStockItem);
    }

    public void stockItemListing() {
        for (int i = 0; i < stockItemList.size(); i++) {
            StockItem temp = (StockItem) stockItemList.get(i);
            if (temp.getProduct() instanceof AnimalProduct) {
                AnimalProduct temp2 = (AnimalProduct) temp.getProduct();
                System.out.println(temp2.toString() + temp.toString());
            } else {
                VegetalProduct temp2 = (VegetalProduct) temp.getProduct();
                System.out.println(temp2.toString() + temp.toString());
            }
        }
    }

    public void sellProduct(int soldProductId, int soldProductQuantity, String date) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date saleDate = format.parse(date);

        boolean idFound = false;

        for (int i = 0; i < stockItemList.size(); i++) {
            StockItem temp = (StockItem) stockItemList.get(i);
            Product temp2 = (Product) temp.getProduct();

            if (temp2.getId() == soldProductId) {
                idFound = true;
                if (temp.getQuantity() > soldProductQuantity) {
                    temp.setQuantity(temp.getQuantity() - soldProductQuantity);
                    stockItemList.set(i, temp);

                    SoldItem tempSoldItem = new SoldItem(temp2, soldProductQuantity, saleDate);
                    soldItemList.add(tempSoldItem);
                } else {
                    System.out.println("Requested quantity exceeds stock quantity.");
                }
                break;
            }

        }

        if (idFound == false) {
            System.out.println("Requested id is not in stock list");
        }
    }

    public void soldItemListing(String date) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date reportDate = format.parse(date);

        for (int i = 0; i < soldItemList.size(); i++) {
            SoldItem temp = (SoldItem) soldItemList.get(i);

            if (temp.getSaleDate().equals(reportDate)) {
                System.out.println(temp.toString());
            }
        }
    }
}