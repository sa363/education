package ru.itfb.data;

import java.util.Date;

public interface DataModel {
    void save();
    void update();
    void delete();

    Object getId();
    Date getCreationDate();
    String getExternalCode();
    boolean isImmutable();

    Date getLastModifiedDate();
    int getNumberOfModifications();
    int getOrderNumber();
    boolean isCurrent();
}
