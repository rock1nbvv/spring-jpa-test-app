package com.example.app.entity.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Vlad Baklaiev
 */
@AllArgsConstructor
@Getter
public class UserUpdateDto {
    private String name;
    private String email;
    private String password;
}
