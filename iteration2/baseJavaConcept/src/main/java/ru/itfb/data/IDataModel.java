package ru.itfb.data;

import java.util.Date;

public interface IDataModel<T> {
    void save();
    void update();
    void delete();
    T getId();
    Date getCreationDate();
    String getExternalCode();
    boolean isImmutable();
    Date getLastModifiedDate();
    int getNumberOfModifications();
    int getOrderNumber();
    boolean isCurrent();
}
