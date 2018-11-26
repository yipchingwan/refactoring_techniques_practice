package com.tws.refactoring.extract_variable;

public class BannerRender {
    void renderBanner(String platform, String browser) {
        final boolean isContainMACAndIE = (platform.toUpperCase().contains("MAC")) &&
                (browser.toUpperCase().contains("IE"));
        if (isContainMACAndIE) System.out.println("Render finished");
        else System.out.println("Render fail");
    }
}
