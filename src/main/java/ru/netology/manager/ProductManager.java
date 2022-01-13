package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

import java.util.Properties;

public class ProductManager {
    private Repository repository;

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public ProductManager() {
    }

    public ProductManager(Repository repository) {
        this.repository = repository;
    }

    public void add(Product item) {
        Repository repository = new Repository();
        repository.save(item);
    }

    public Product[] searchByText(String text) {
        Product[] result = new Product[0];
        for (Product item : repository.showAll()) {
            if (matches(item, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(repository.showAll(), 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product item, String search) {
        if (item instanceof Book) {
            Book book = (Book) item;
            if (book.getAuthor().contains(search)) {
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }
            return false;
        }

        if (item instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) item;
            if (smartphone.getProducer().contains(search)) {
                return true;
            }
            if (smartphone.getName().contains(search)) {
                return true;
            }
            return false;
        }

        return false;
    }
}

