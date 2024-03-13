package ru.itfb.model;

import lombok.Getter;
import lombok.Setter;
import ru.itfb.data.DataModel;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class UserModel implements DataModel {

    public UserModel(Long id, String name) {
        this.id = id;
        this.name = name;
        this.current = true; // По умолчанию объект актуален при создании
    }

    @Setter
    private Long id;
    private String name;
    private Date creationDate;

    private String externalCode;

    private int orderNumber;
    @Getter
    @Setter
    private boolean current;

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
        return id;
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
        // Проверяем какие-то условия, определяющие неизменность объекта
        // Например, если объект создан больше недели назад, считаем его неизменным
        Date currentDate = new Date();
        long differenceInMilliseconds = currentDate.getTime() - creationDate.getTime();
        long differenceInDays = TimeUnit.MILLISECONDS.toDays(differenceInMilliseconds);

        return differenceInDays >= 7;
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
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", externalCode='" + externalCode + '\'' +
                ", orderNumber=" + orderNumber +
                ", current=" + current +
                '}';
    }
}
