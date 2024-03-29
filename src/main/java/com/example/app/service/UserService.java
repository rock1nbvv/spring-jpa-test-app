package com.example.app.service;

import com.example.app.entity.User;
import com.example.app.entity.request.UserCreateDto;
import com.example.app.entity.request.UserDto;
import com.example.app.entity.request.UserUpdateDto;
import com.example.app.exception.NotFoundException;
import com.example.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Vlad Baklaiev
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(UserCreateDto userCreateDto) {
        User user = User.builder()
                .name(userCreateDto.getName())
                .email(userCreateDto.getEmail())
                .password(userCreateDto.getPassword())
                .build();
        return userRepository.save(user);
    }

    public List<UserDto> getAll() {
        List<UserDto> userDtoList = userRepository.findUserBy();
        return userDtoList;
    }

    public Optional<UserDto> getOneById(Long id) {
        return Optional.ofNullable(userRepository.getViewById(id).orElse(null));
    }

    public void update(Long userId, UserUpdateDto userUpdateDto) {
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new NotFoundException("Entity " + User.class + " not found by id - " + userId,
                        User.class,
                        userId));

        if (Objects.nonNull(userUpdateDto.getName()) && !"".equalsIgnoreCase(userUpdateDto.getName())) {
            user.setName(userUpdateDto.getName());
        }
        if (Objects.nonNull(userUpdateDto.getEmail()) && !"".equalsIgnoreCase(userUpdateDto.getEmail())) {
            user.setEmail(userUpdateDto.getEmail());
        }
        if (Objects.nonNull(userUpdateDto.getPassword()) && !"".equalsIgnoreCase(userUpdateDto.getPassword())) {
            user.setPassword(userUpdateDto.getPassword());
        }

        userRepository.save(user);
    }

    public void deleteById(Long userId) {
        userRepository.getEntityById(userId)
                .ifPresentOrElse(
                        user -> userRepository.delete(user),
                        () -> {
                            throw new NotFoundException("Entity " + User.class + " not found by id - " + userId, User.class, userId);
                        }
                );
    }
}
