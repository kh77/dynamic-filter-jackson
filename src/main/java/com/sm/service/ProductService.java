package com.sm.service;

import com.sm.entity.Product;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class ProductService {

    public static final Map<Long, Product> map = new HashMap<>();

    public Product getProductById(Long id) {
        return findById(id);
    }

    @PostConstruct
    public void run() {
        for (int i = 0; i < 10000; i++) {
            map.put(Long.valueOf(i), (new Product(Long.valueOf(i), getAlphaNumericString(5), new Random().nextInt(10), new Random().nextInt(100))));
        }
    }

    static String getAlphaNumericString(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length() * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

    public Product findById(Long id) {
        return map.get(id);
    }
}
