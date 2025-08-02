package com.vuduy.restfulapi.service;

import java.util.List;
import java.util.Optional;

import com.vuduy.restfulapi.entity.User;

public interface UserService {

    // Tạo mới người dùng
    public User createUser(User user);

    // Gọi tất cả người dùng
    public List<User> getAllUsers();

    // Tìm kiếm người dùng theo id
    public Optional<User> getUserById(Long id);

    // Cập nhật người dùng
    public User updateUser(Long id, User updateUser);

    // Xóa người dùng
    public void deleteUser(Long id);

}
