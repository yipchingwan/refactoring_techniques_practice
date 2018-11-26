package com.tws.refactoring.extract_variable;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriceCalculatorTest {
    @Test
    public void should_priceCalculator_get_price_successfully(){
        int quantity = 5;
        int itemPrice = 20;
        PriceCalculator priceCalculator = new PriceCalculator();
        double price =  priceCalculator.getPrice(quantity, itemPrice);

        assertEquals(110.0, price,0.01);
    }
}
