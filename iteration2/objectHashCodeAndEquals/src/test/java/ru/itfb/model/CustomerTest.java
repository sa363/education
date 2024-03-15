package ru.itfb.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Logger log = LoggerFactory.getLogger(CustomerTest.class);

    @Test
    void Customer_toStringCustom() {
        Customer customer = new Customer.CustomerBuilder()
                .id(1L)
                .lName("lName")
                .fName("fName")
                .build();

        log.info(customer::toString);

        assertTrue(customer.toString().contains("Customer{id=1, fName='fName', lName='lName'}"));
    }

    @Test
    @DisplayName("Использование default метода toString из класса Object который формирует строку по принципу имя класса + \"@\" + Integer.toHexString(hashCode())")
    void Customer_toString() {
        CustomerWithOutToString customer = new CustomerWithOutToString.CustomerWithOutToStringBuilder()
                .id(1L)
                .lName("lName")
                .fName("fName")
                .build();

        log.info(customer::toString);

        assertTrue(customer.toString().contains(customer.getClass().getName() + "@" + Integer.toHexString(customer.hashCode())));
    }

    @Test
    @DisplayName("Сравнение default hashCode() и переопределенного")
    void Customer_hashCodeAndEquals() {

        // 1. Если два объекта равны по методу equals(), то у них должны быть одинаковые хеш-коды.
        //geven
        Customer customer1 = new Customer.CustomerBuilder()
                .id(1L)
                .lName("lName")
                .fName("fName")
                .build();
        Customer customer2 = new Customer.CustomerBuilder()
                .id(1L)
                .lName("lName")
                .fName("fName")
                .build();
        //when
        assertTrue(
        //then
                customer1.equals(customer2) && customer1.hashCode() == customer2.hashCode()
        );
    }

}