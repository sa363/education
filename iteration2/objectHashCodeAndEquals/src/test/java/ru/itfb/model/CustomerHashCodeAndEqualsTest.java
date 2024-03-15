package ru.itfb.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Методы hashCode() и equals()")
class CustomerHashCodeAndEqualsTest {

    Logger log = LoggerFactory.getLogger(CustomerHashCodeAndEqualsTest.class);


    @Test
    @DisplayName("1. Переопределены. Если два объекта равны по методу equals(), то у них должны быть одинаковые хеш-коды.")
    void Customer_hashCodeAndEquals() {

        //geven
        Customer customer1 = new Customer(1L, "lName", "fName");
        Customer customer2 = new Customer(1L, "lName", "fName");
        //when
        assertTrue(
        //then
                customer1.equals(customer2) && customer1.hashCode() == customer2.hashCode()
        );
    }

    @Test
    @DisplayName("2. Default. Если два объекта равны по методу equals(), то у них должны быть одинаковые хеш-коды.")
    void Customer_defaults() {

        //geven
        CustomerWithOutEqualsAndHashCode customer3 = new CustomerWithOutEqualsAndHashCode(1L, "lName", "fName");
        CustomerWithOutEqualsAndHashCode customer4 = new CustomerWithOutEqualsAndHashCode(1L, "lName", "fName");
        // Т.к. указывают на различные объекты, хотя содержат одинаковые значения
        //when
        assertNotEquals(
                //then
                customer3, customer4
        );
    }

}