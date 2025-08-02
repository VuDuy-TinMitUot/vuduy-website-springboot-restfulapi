package com.vuduy.restfulapi.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vuduy.restfulapi.entity.User;
import com.vuduy.restfulapi.service.UserService;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<ApiResponse<User>> createUser(@RequestBody User user) {
        User created = this.userService.createUser(user);

        var resutl = new ApiResponse<User>(HttpStatus.CREATED, "createUser", created, null);
        return ResponseEntity.status(HttpStatus.CREATED).body(resutl);
    }

    @GetMapping("/users")
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
        List<User> getAll = this.userService.getAllUsers();

        var result = new ApiResponse<List<User>>(HttpStatus.OK, "getAllUser", getAll, null);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ApiResponse<Optional<User>>> searchUser(@PathVariable Long id) {
        Optional<User> current = this.userService.getUserById(id);

        var result = new ApiResponse<>(HttpStatus.OK, "SearchUser", current, null);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable Long id, @RequestBody User user) {
        User currentUser = this.userService.updateUser(id, user);

        var result = new ApiResponse<>(HttpStatus.OK, "updateUser", currentUser, null);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);

        var result = new ApiResponse<>(HttpStatus.NO_CONTENT, "deleteUser", null, null);
        return ResponseEntity.ok().body(result);
    }
}
