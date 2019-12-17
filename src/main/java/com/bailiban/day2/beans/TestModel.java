package com.bailiban.day2.beans;

import com.bailiban.day1.helloworld.model.User;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Map;
import java.util.Set;

@Data
@ToString
@Accessors(chain = true)
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class TestModel {

    private int id;
    private String name;
    private User user;
    private Long[] priceArray;
    private Set<String> descSet;
    private Map<String, String> myMap;

    public TestModel(int id, String name, User user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }
}
