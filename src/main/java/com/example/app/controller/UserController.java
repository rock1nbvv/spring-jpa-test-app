package com.example.app.controller;

import com.example.app.data.ResponseWrapper;
import com.example.app.entity.User;
import com.example.app.entity.request.UserCreateDto;
import com.example.app.entity.request.UserDto;
import com.example.app.entity.request.UserUpdateDto;
import com.example.app.exception.NotFoundException;
import com.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author Vlad Baklaiev
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseWrapper<User> createUser(final @RequestBody UserCreateDto userCreateDto) {
        return new ResponseWrapper<>(userService.create(userCreateDto));
    }

    @GetMapping("/{userId}")
    public ResponseWrapper<UserDto> getUserById(final @PathVariable Long userId) {
        Optional<UserDto> user = userService.getOneById(userId);
        if (user.isEmpty()) {
            throw new NotFoundException("Entity " + User.class + " not found by id - " + userId, User.class, userId);
        } else return new ResponseWrapper(user);
    }

    @GetMapping("/exception")
    public UserDto getException() {
        throw new NotFoundException("Vlad", User.class, 666);
    }

    @GetMapping
    public ResponseWrapper<List<UserDto>> getUserAll() {
        return new ResponseWrapper(userService.getAll());
    }

    @PostMapping("/{userId}")
    public void updateUserById(final @PathVariable Long userId, final @RequestBody UserUpdateDto userUpdateDto) throws Exception {
        userService.update(userId, userUpdateDto);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(final @PathVariable Long userId) throws Exception {
        Optional<UserDto> user = userService.getOneById(userId);
        if (user.isEmpty()) {
            throw new NotFoundException("Entity " + User.class + " not found by id - " + userId, User.class, userId);
        } else userService.deleteById(userId);
    }
}
