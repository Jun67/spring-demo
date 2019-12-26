package com.bailiban.day5.transaction.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cashier")
public class CashierImpl implements Cashier {
    @Autowired
    private BookShopService bookShopService;

    @Autowired
    private BookShopDao bookShopDao;

    @Transactional
    @Override
    public void checkout(String username, List<String> isbns) {

        bookShopDao.updateBookStock("1003");
        try {
            for (String isbn : isbns) {
                bookShopService.purchase(username, isbn);
            }
        } catch (UserAccountException e) {
            e.printStackTrace();
        }
    }
}
