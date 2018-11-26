package com.tws.refactoring.extract_method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class OwingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void should_print_result_based_on_order() {
        double amount = 4.0;
        String serviceName = "First Order";
        Order orderA = new Order(amount);
        Order orderB = new Order(amount);
        Order orderC = new Order(amount);
        Order orderD = new Order(amount);
        List<Order> orders = new ArrayList<Order>();
        orders.addAll(Arrays.asList(orderA, orderB, orderC, orderD));

        OwingPrinter printer = new OwingPrinter();
        printer.printOwing(serviceName, orders);

        String expected = "*****************************\r\n" +
                "****** Customer totals ******\r\n" +
                "*****************************\r\n" +
                "name: First Order\r\n" +
                "amount: 16.0\r\n";
        assertEquals(expected, outContent.toString());
    }
}