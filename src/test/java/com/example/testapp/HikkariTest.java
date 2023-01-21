package com.example.testapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Vlad Baklaiev
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        properties = "spring.datasource.type=com.zaxxer.hikari.HikariDataSource"
)
public class HikkariTest {
    @Autowired
    private DataSource dataSource;

    @Test
    public void hikariConnectionPoolIsConfigured() {
        assertEquals("com.zaxxer.hikari.HikariDataSource", dataSource.getClass().getName());
    }
}
