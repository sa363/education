package ru.itfb.model;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataModelTest {

    Logger logger = LoggerFactory.getLogger(DataModelTest.class);


    @Test
    public void testUserIsCurrent() {
        UserModel user1 = new UserModel(1L, "John");
        assertEquals(true, user1.isCurrent());
        logger.info(() -> user1.toString());

        user1.setCurrent(false);
        assertEquals(false, user1.isCurrent());
    }

    @Test
    public void testProductIsCurrent() {
        ProductModel product1 = new ProductModel("P001", "Phone");
        assertEquals(true, product1.isCurrent());

        product1.setCurrent(false);
        assertEquals(false, product1.isCurrent());
    }

    @Test
    public void testGetUserIdAndProductId() {
        UserModel user2= new UserModel(2L, "Jane");
        assertEquals(2L, (long)user2.getId());

        ProductModel product2= new ProductModel("P002", "Laptop");
        assertEquals("P002", (String)product2.getId());
    }

}