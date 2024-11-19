package com.spin.lab2;

import java.util.List;

public class DataProcessorImpl implements DataProcessor{
    @Override
    public boolean processData(List<Data> dataList) {
        if (dataList == null) {
            throw new IllegalArgumentException("Data is invalid");
        }
        return true;
    }
}
