import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void removeExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Чемодан", 3_500);
        Product product2 = new Product(2, "Куртка", 5_000);
        Product product3 = new Product(3, "Наушники", 1_200);
        Product product4 = new Product(4, "Микрофон", 2_400);
        Product product5 = new Product(5, "Ноутбук", 85_500);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);
        repo.remove(3);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product4, product5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeNonExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Чемодан", 3500);
        Product product2 = new Product(2, "Куртка", 5000);
        Product product3 = new Product(3, "Наушники", 1200);
        Product product4 = new Product(4, "Микрофон", 2400);
        Product product5 = new Product(5, "Ноутбук", 85_500);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(6)
        );
    }
}