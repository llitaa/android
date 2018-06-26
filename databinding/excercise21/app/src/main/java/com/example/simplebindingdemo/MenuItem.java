package com.example.simplebindingdemo;

import java.util.HashMap;
import java.util.Map;

public class MenuItem {
    public boolean isSpecial;
    public String flavor;
    public String price;
    public int index;
    public Map<String, String> map = new HashMap<>();

    public MenuItem(boolean isSpecial, String flavor, String price, int index) {
        this.isSpecial = isSpecial;
        this.flavor = flavor;
        this.price = price;
        this.index = index;

        map.put("flavor", flavor);
        map.put("price", price);
    }

}
