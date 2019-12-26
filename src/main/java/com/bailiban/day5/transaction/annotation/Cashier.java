package com.bailiban.day5.transaction.annotation;

import java.util.List;

public interface Cashier {
    public void checkout(String username, List<String> isbns);
}
