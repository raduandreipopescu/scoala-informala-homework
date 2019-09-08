package main;

/**
 * Main class that operates the management of the store.
 *
 * @author Radu Popescu
 */

import java.text.ParseException;
import java.util.Scanner;

public class StoreManagement {
    public static void main(String[] args) throws ParseException {

        Store store = new Store();

        int option = 0;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Create product and add it to stock\n" +
                    "2. Sell product\n" +
                    "3. Display daily sales report\n" +
                    "4. Exit\n" +
                    "\n" +
                    "Choose an option:");
            option = sc.nextInt();

            switch (option) {
                case 1: {
                    sc = new Scanner(System.in);
                    System.out.println("Choose product type (1 - animal; 2 - vegetal): \n" +
                            "Other choice returns to main menu.");
                    int option2 = sc.nextInt();

                    switch (option2) {
                        case 1: {
                            String name = store.readString(
                                    "Insert product name from the following list: milk, eggs, cheese, yogurt, sour cream");
                            int price = store.readInt("Insert product price");
                            String date = store.readString(
                                    "Insert product validityDate in yyyy-MM-dd format");
                            int weight = store.readInt("Insert product weight");
                            int storageTemperature = store.readInt(
                                    "Insert storage temperature for animal product");
                            int quantity = store.readInt("Insert quantity");

                            store.addAnimalProduct(name, price, date, weight, storageTemperature, quantity);
                            break;
                        }
                        case 2: {
                            store.stockItemListing();
                            String name = store.readString(
                                    "Insert product name");
                            int price = store.readInt("Insert product price");
                            String date = store.readString(
                                    "Insert product validityDate in yyyy-MM-dd format");
                            int weight = store.readInt("Insert product weight");
                            String vitamins = store.readString(
                                    "Insert vitamin list for vegetal product");
                            int quantity = store.readInt("Insert quantity");

                            store.addVegetalProduct(name, price, date, weight, vitamins, quantity);
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    int soldProductId = store.readInt("Insert ID of product to be sold: ");
                    int soldProductQuantity = store.readInt("Insert quantity of product to be sold: ");
                    String date = store.readString("Insert sale date in yyyy-MM-dd format: ");
                    store.sellProduct(soldProductId, soldProductQuantity, date);
                    break;
                }
                case 3: {
                    String date = store.readString("Insert sale date in yyyy-MM-dd format: ");
                    store.soldItemListing(date);
                    break;
                }
                case 4: {
                    break;
                }
                default: {
                    System.out.println("Please choose a valid option");
                    break;
                }
            }
        } while (option != 4);
    }
}