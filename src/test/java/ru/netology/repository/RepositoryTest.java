package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    Product book1 = new Book(01, "Ono", 450, "Stiven King");
    Product book2 = new Book(02, "3 Tovarishcha", 380, "Remark");
    Product smartphone1 = new Smartphone(03, "Samsung 310", 6800, "Samsung");
    Product smartphone2 = new Smartphone(04, "Iphone 8", 55000, "Apple");

    @Test
    public void shouldRemoveById () {
        Repository repository = new Repository(new Product[]{book1, book2, smartphone1});

        Product[] expected = {book1, smartphone1};
        Product[] actual = repository.removeById(02);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveNotFoundId () {
        Repository repository = new Repository(new Product[]{book1, book2, smartphone1});

        assertThrows(NotFoundException.class, () -> {
            repository.findById(76);
        });
    }

}