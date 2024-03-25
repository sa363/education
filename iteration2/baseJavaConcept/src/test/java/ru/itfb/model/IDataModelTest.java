package ru.itfb.model;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IDataModelTest {
    Logger logger = LoggerFactory.getLogger(IDataModelTest.class);


    @Test
    public void testUserIsCurrent() {
        UserModel user = new UserModel(1L, "John");
        assertEquals(true, user.isCurrent());
        logger.info(user::toString);

        user.setCurrent(false);
        assertEquals(false, user.isCurrent());
    }

    @Test
    public void testProductIsCurrent() {
        ProductModelI product1 = new ProductModelI("P001", "Phone");
        assertEquals(true, product1.isCurrent());
        product1.save();

        product1.setCurrent(false);
        assertEquals(false, product1.isCurrent());
    }

    @Test
    public void testGetUserIdAndProductId() {
        UserModel user2= new UserModel(2L, "Jane");
        assertEquals(2L, (Long) user2.getId());
        logger.info(()->user2.getId().getClass().toString());

        ProductModelI product2= new ProductModelI("P002", "Laptop");
        assertEquals("P002", (String)product2.getId());
    }

}