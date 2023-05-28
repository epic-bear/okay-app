package com.app.okay.service;

import com.app.okay.domain.User;
import com.app.okay.repository.UserRepository;
import com.app.okay.request.UserRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        return userRepository.save(user);
    }

    public User getUserById(long userId) throws Exception {
        return userRepository.findById(userId).orElseThrow(() -> new Exception("exception"));
    }

    public User updateUser(UserRequest userRequest) throws Exception {
        Optional<User> optionalUser = userRepository.findById(userRequest.getUserId());
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            String name = userRequest.getName();
            if (name != null) {
                existingUser.setName(name);
            }
            String password = userRequest.getPassword();
            if (password != null) {
                existingUser.setPassword(password);
            }
            userRepository.save(existingUser);
            return existingUser;
        } else {
            throw new Exception("exception");
        }
    }
}
