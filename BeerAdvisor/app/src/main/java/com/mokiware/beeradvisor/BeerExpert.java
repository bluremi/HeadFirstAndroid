package com.mokiware.beeradvisor;

/**
 * Created by Phil on 7/3/2017.
 */

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
    List<String> getBrands(String color){
        List<String> brands = new ArrayList<String>();

        switch (color) {
            case "light":
                brands.add("Czeckvar Pilsner");
                brands.add("Bud Light");
                brands.add("Oscar Blues Pils");
                break;
            case "amber":
                brands.add("Fat Tire Amber Ale");
                brands.add("Montauk Amber Ale");
                brands.add("Abita Purple Haze");
                break;
            case "brown":
                brands.add("Brooklyn Brown Ale");
                brands.add("Newcastle Brown Ale");
                brands.add("Founders Sumatra Mountain Brown Ale");
                break;
            case "dark":
                brands.add("Foothills Sexual Chocolate");
                brands.add("Allagash Black");
                brands.add("Barrier Lights Out Stout");
                break;
            default:
                brands.add("I don't recognize the type of beer you're asking for.");
                break;
        }
        return brands;
    }
}
