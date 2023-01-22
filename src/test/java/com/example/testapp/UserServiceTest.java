package com.example.testapp;

import com.example.app.entity.User;
import com.example.app.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * @author Vlad Baklaiev
 */
@ExtendWith(SpringExtension.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        List<User> users = userService.list();

        Assertions.assertEquals(1, users.size());
    }
}
