import main.Store;
import org.junit.Test;
import product.Product;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StoreTest {

    @Test
    public void addProduct() throws ParseException {
        Store storeObj = new Store();
        Product product = storeObj.addProduct("Cantar", 600, "2019-07-23", 90);
        assertNotNull(product);
    }

    @Test
    public void addAnimalProduct() throws ParseException {
        Store storeObj = new Store();
        int initialListSize = storeObj.stockItemList.size();
        storeObj.addAnimalProduct("milk", 5, "2019-08-31", 1, 5, 100);
        int finalListSize = storeObj.stockItemList.size();
        assertEquals(initialListSize + 1, finalListSize);
    }

    @Test
    public void addVegetalProduct() throws ParseException {
        Store storeObj = new Store();
        int initialListSize = storeObj.stockItemList.size();
        storeObj.addVegetalProduct("carrot", 3, "2019-12-31", 1, "A", 500);
        int finalListSize = storeObj.stockItemList.size();
        assertEquals(initialListSize + 1, finalListSize);
    }

    @Test
    public void sellProduct() throws ParseException {
        Store storeObj = new Store();
        int initialListSize = storeObj.soldItemList.size();
        storeObj.addVegetalProduct("carrot", 3, "2019-12-31", 1, "A", 500);
        storeObj.sellProduct(1, 50, "2019-06-30");
        int finalListSize = storeObj.soldItemList.size();
        assertEquals(initialListSize + 1, finalListSize);
    }
}