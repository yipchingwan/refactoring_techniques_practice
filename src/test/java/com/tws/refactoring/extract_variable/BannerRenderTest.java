package com.tws.refactoring.extract_variable;

import com.tws.refactoring.extract_variable.BannerRender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BannerRenderTest {
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
    public void should_banner_render_print_something(){
        BannerRender bannerRender = new BannerRender();
        bannerRender.renderBanner("MAC BOOK", "IEIE");

        String expected = "Render finished\r\n";
        assertEquals(expected, outContent.toString());
    }
}
