package ru.gontov.enterprise.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    protected Long id;

    @Nullable
    private Date created;

    @Nullable
    private Date updated;

    @NotNull
    public Long getId() {
        return id;
    }

    public void setId(@NotNull Long id) {
        this.id = id;
    }

    @Nullable
    public Date getCreated() {
        return created;
    }

    public void setCreated(@Nullable Date created) {
        this.created = created;
    }

    @Nullable
    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(@Nullable Date updated) {
        this.updated = updated;
    }

}
