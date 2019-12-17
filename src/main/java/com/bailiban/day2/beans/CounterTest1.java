package com.bailiban.day2.beans;

import lombok.Data;

@Data
public class CounterTest1 {

    private Counter counter;

    public void count() {
        this.counter.inc();
    }
}
