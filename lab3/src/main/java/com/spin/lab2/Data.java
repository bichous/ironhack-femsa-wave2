package com.spin.lab2;

import lombok.Builder;

@lombok.Data
@Builder
public class Data {

    private final int id;

    private final String color;

    private final Double price;

}
