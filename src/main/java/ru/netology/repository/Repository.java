package ru.netology.repository;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

public class Repository {
    private Product[] items = new Product[0];

    public Repository(Product[] items) {
        this.items = items;
    }

    public Repository() {
    }

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Product[] showAll() {
        return items;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        throw new NotFoundException("Element with id:" + id + " not found");
    }

    public Product[] removeById(int id) {
        findById(id);
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return items;
    }

    public Product[] getItems() {
        return items;
    }

    public void setItems(Product[] items) {
        this.items = items;
    }
}