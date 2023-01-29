package com.example.testapp;

import com.example.app.entity.User;
import com.example.app.entity.request.UserDto;
import com.example.app.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * @author Vlad Baklaiev
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = UserService.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        List<UserDto> users = userService.getAll();

        Assertions.assertEquals(true, users.size()>0);
    }
}
