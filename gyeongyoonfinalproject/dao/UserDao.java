package com.example.gyeongyoonfinalproject.dao;

import com.example.gyeongyoonfinalproject.entity.User;
import com.example.gyeongyoonfinalproject.exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> users = new ArrayList<>();
    private static long idCounter = 1;

    public User addUser(User user) {
        user.setId(idCounter++);
        users.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(long id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("유저가 없습니다."));
    }

    public User updateUser(long id, String name, String email) {
        User user = getUserById(id);
        user.setName(name);
        user.setEmail(email);
        return user;
    }
}
