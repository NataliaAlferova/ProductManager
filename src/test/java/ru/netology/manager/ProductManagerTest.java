package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    Product book1 = new Book(01, "Ono", 450, "Stiven King");
    Product book2 = new Book(02, "3 Tovarishcha", 380, "Remark");
    Product smartphone1 = new Smartphone(03, "Samsung 310", 6800, "Samsung");
    Product smartphone2 = new Smartphone(04, "Iphone 8", 55000, "Apple");

    @Test
    public void shouldSearchByNameNoEmpty() {
        ProductManager productManager = new ProductManager();
        Repository repository = new Repository(new Product[]{book1, book2, smartphone1});
        productManager.setRepository(repository);

        Product[] expected = {book1};
        Product[] actual = productManager.searchByText("Ono");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameEmpty() {
        ProductManager productManager = new ProductManager();
        Repository repository = new Repository(new Product[0]);
        productManager.setRepository(repository);

        Product[] expected = {};
        Product[] actual = productManager.searchByText("Ono");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameNoResalt() {
        ProductManager productManager = new ProductManager();
        Repository repository = new Repository(new Product[]{book1, book2, smartphone1});
        productManager.setRepository(repository);

        Product[] expected = {};
        Product[] actual = productManager.searchByText("Skazka");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {
        ProductManager productManager = new ProductManager();
        Repository repository = new Repository(new Product[]{book1, book2, smartphone1});
        productManager.setRepository(repository);

        Product[] expected = {book1};
        Product[] actual = productManager.searchByText("King");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByName() {
        ProductManager productManager = new ProductManager();
        Repository repository = new Repository(new Product[]{book1, book2, smartphone2});
        productManager.setRepository(repository);

        Product[] expected = {smartphone2};
        Product[] actual = productManager.searchByText("Iphone");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByProducer() {
        ProductManager productManager = new ProductManager();
        Repository repository = new Repository(new Product[]{book1, book2, smartphone2});
        productManager.setRepository(repository);

        Product[] expected = {smartphone2};
        Product[] actual = productManager.searchByText("Apple");

        assertArrayEquals(expected, actual);
    }
}