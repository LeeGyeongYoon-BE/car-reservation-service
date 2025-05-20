package com.example.gyeongyoonfinalproject.service;

import com.example.gyeongyoonfinalproject.entity.User;
import com.example.gyeongyoonfinalproject.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private static List<User> users = new ArrayList<>();
    private static long userId = 1;

    // 기존 사용자 추가 메소드
    public User addUser(String name, String email) {
        if (users.size() >= 10) {
            throw new BadRequestException("유저는 최대 10명까지 등록할 수 있습니다.");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new BadRequestException("유저 이름은 필수이며, 공백일 수 없습니다.");
        }

        if (email == null || email.trim().isEmpty()) {
            throw new BadRequestException("유저 이메일은 필수이며 공백일 수 없습니다.");
        }

        User user = new User(userId++, name, email);
        users.add(user);
        return user;
    }

    // User ID로 유저를 찾기 위한 메소드
    public Optional<User> getUserById(long id) {
        return users.stream().filter(u -> u.getId() == id).findFirst();
    }

    // 유저 업데이트 메소드
    public User updateUser(long id, String name, String email) {
        // 해당 ID로 유저 찾기
        User user = getUserById(id).orElseThrow(() -> new BadRequestException("업데이트 대상 유저가 존재하지 않습니다."));

        // 유효성 검증 (필요시 추가)
        if (name == null || name.trim().isEmpty()) {
            throw new BadRequestException("유저 이름은 필수이며, 공백일 수 없습니다.");
        }

        if (email == null || email.trim().isEmpty()) {
            throw new BadRequestException("유저 이메일은 필수이며, 공백일 수 없습니다.");
        }

        // 유저 정보 업데이트
        user.setName(name);
        user.setEmail(email);

        return user;
    }

    // 유저 리스트 조회 메소드
    public List<User> getAllUsers() {
        if (users.isEmpty()) {
            throw new BadRequestException("유저가 없습니다.");
        }
        return users;
    }
}
