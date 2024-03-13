package ru.itfb.model;

import lombok.Getter;
import lombok.Setter;
import ru.itfb.data.DataModel;

import java.util.Date;

@Getter
@Setter
public class ProductModel implements DataModel {
    @Setter
    private String id;
    private String name;
    @Setter
    private Date creationDate;
    @Setter
    private String externalCode;
    @Setter
    private int orderNumber;
    @Setter
    private boolean current;

    public ProductModel(String id, String name) {
        this.id = id;
        this.name = name;
        this.current = true; // По умолчанию объект актуален при создании
    }

    @Override
    public void save() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public Object getId() {
        return this.id;
    }

    @Override
    public Date getCreationDate() {
        return null;
    }

    @Override
    public String getExternalCode() {
        return null;
    }

    @Override
    public boolean isImmutable() {
        return false;
    }

    @Override
    public Date getLastModifiedDate() {
        return null;
    }

    @Override
    public int getNumberOfModifications() {
        return 0;
    }

    @Override
    public int getOrderNumber() {
        return 0;
    }

    @Override
    public boolean isCurrent() {
        return this.current;
    }
}
