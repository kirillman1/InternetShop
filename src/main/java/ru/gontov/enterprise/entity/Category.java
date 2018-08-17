package ru.gontov.enterprise.entity;

import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity бины - это классы, которые превращаются в таблицы базы данных
 * при деплойменте приложения на сервер приложений
 */
@Entity
public class Category extends AbstractEntity {

    @Column
    @Nullable
    private String name = "";

    @Column
    @Nullable
    private String description = "";

    @Column
    @OneToMany
    private List<Product> products = new ArrayList<>();

    public Category() {
    }

    public Category(@Nullable String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
