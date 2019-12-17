package com.bailiban.day2.beans;

import lombok.Data;

@Data
public class Counter {

    private int count;

    public void inc() {
        System.out.println("count: " + ++this.count);
    }
}
