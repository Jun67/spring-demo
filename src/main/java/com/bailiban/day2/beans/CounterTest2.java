package com.bailiban.day2.beans;

import lombok.Data;

@Data
public class CounterTest2 {

    private Counter counter;

    public void count() {
        this.counter.inc();
    }
}
