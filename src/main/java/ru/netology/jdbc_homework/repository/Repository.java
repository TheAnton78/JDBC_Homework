package ru.netology.jdbc_homework.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.core.io.ClassPathResource;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.List;

import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository {
    private final String sqlScript = read("script.sql");
    @PersistenceContext
    EntityManager entityManager;

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        List<?> result = entityManager.createQuery("SELECT order.productName FROM Order order \n" +
                        "JOIN Customer customer ON customer = order.customer\n" +
                        "where customer.name = ?1")
                .setParameter(1, name).getResultList();


//        Map<String, Object> params = new HashMap<>();
//        params.put("firstName", name);
//        System.out.println(params.get("firstName"));
//        List<String> productNames = namedParameterJdbcTemplate.query(sqlScript, params,
//                (reseultSet, rowNum) -> {
//                    return reseultSet.getString("product_name");
//        });
//        System.out.println(productNames);
        return (List<String>) result;
    }
}
