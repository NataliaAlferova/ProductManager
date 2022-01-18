package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductManager productManager = new ProductManager(new Repository(new Product[]{}));
    Product book1 = new Book(01, "Ono", 450, "Stiven King");
    Product book2 = new Book(02, "3 Tovarishcha", 380, "Remark");
    Product smartphone1 = new Smartphone(03, "Samsung 310", 6800, "Samsung");
    Product smartphone2 = new Smartphone(04, "Iphone 8", 55000, "Apple");
    Product book3 = new Book(05, "Pod kupolom", 460, "Stiven King");


    @Test
    public void shouldSearchByNameNoEmpty() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(smartphone1);

        Product[] expected = {book1};
        Product[] actual = productManager.searchByText("Ono");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameEmpty() {
        Product[] expected = {};
        Product[] actual = productManager.searchByText("Ono");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameNoResalt() {

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(smartphone1);

        Product[] expected = {};
        Product[] actual = productManager.searchByText("Skazka");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(smartphone1);

        Product[] expected = {book1};
        Product[] actual = productManager.searchByText("King");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByName() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(smartphone2);

        Product[] expected = {smartphone2};
        Product[] actual = productManager.searchByText("Iphone");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByProducer() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(smartphone2);

        Product[] expected = {smartphone2};
        Product[] actual = productManager.searchByText("Apple");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthorAnyResult() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(smartphone1);
        productManager.add(book3);

        Product[] expected = {book1, book3};
        Product[] actual = productManager.searchByText("King");

        assertArrayEquals(expected, actual);
    }

}