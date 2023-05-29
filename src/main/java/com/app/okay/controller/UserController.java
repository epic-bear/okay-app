package com.app.okay.controller;

import com.app.okay.domain.User;
import com.app.okay.request.UserRequest;
import com.app.okay.response.UserResponse;
import com.app.okay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String getCreateUserPage() {
        return "createUser";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "loginPage";
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        User user = userService.createUser(userRequest);
        UserResponse response = new UserResponse(user.getUserId(), user.getName(), user.getEmail(), user.getPassword());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long userId) throws Exception {
        User user = userService.getUserById(userId);
        UserResponse response = new UserResponse(user.getUserId(), user.getName(), user.getEmail(), user.getPassword());
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest) throws Exception {
        User user = userService.updateUser(userRequest);
        UserResponse response = new UserResponse(user.getUserId(), user.getName(), user.getEmail(), user.getPassword());
        return ResponseEntity.ok(response);
    }
}
