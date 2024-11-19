package com.spin.lab2;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    List<Data> list = new ArrayList<>();

    public List<Data> generateData() {
        list.add(Data.builder()
                .id(1)
                .color(Color.BLUE.toString())
                .price(120.35)
                .build());

        list.add(Data.builder()
                .id(1)
                .color(Color.RED.toString())
                .price(100.25)
                .build());

        list.add(Data.builder()
                .id(1)
                .color(Color.GREEN.toString())
                .price(99.99)
                .build());

        return list;
    }

    public void cleanList() {
        list = new ArrayList<>();
    }
}
