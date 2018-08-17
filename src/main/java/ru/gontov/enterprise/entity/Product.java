package ru.gontov.enterprise.entity;


import org.jetbrains.annotations.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Product extends AbstractEntity {

    @Column
    @Nullable
    private String name = null;

    @Column
    @Nullable
    private String description = null;

    @ManyToOne
    private Category category;

    public Product() {
    }

    public Product(@Nullable String name) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
