package com.vuduy.restfulapi.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vuduy.restfulapi.entity.User;
import com.vuduy.restfulapi.repository.UserRepository;
import com.vuduy.restfulapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public User updateUser(Long id, User updateUser) {
        return this.userRepository.findById(id).map(update -> {
            update.setName(updateUser.getName());
            update.setEmail(updateUser.getEmail());
            return this.userRepository.save(update);
        }).orElseThrow(() -> new NoSuchElementException("Không tìm thấy người dùng"));
    }

    @Override
    public void deleteUser(Long id) {
        if (!this.userRepository.existsById(id)) {
            throw new NoSuchElementException("Không tìm thấy id người dùng");
        } else {
            this.userRepository.deleteById(id);
        }
    }

}
