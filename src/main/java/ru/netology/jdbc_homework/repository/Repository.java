package ru.netology.jdbc_homework.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String sqlScript = read("script.sql");

    public List<String> getProductName(String name){
        Map<String, Object> params = new HashMap<>();
        params.put("firstName", name);
        System.out.println(params.get("firstName"));
        List<String> productNames = namedParameterJdbcTemplate.query(sqlScript, params,
                (reseultSet, rowNum) -> {
                    return reseultSet.getString("product_name");
        });
        System.out.println(productNames);
        return productNames;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
