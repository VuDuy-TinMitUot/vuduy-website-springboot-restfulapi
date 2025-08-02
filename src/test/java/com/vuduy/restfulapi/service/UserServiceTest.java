package com.vuduy.restfulapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vuduy.restfulapi.entity.User;
import com.vuduy.restfulapi.repository.UserRepository;

@ExtendWith(MockitoExtension.class) // Tựa controller, service, repository
public class UserServiceTest {

    @Mock // Thành phần dưới giả lập FAKE không lưu database
    private UserRepository userRepository;

    @InjectMocks // Thành phần dưới là thật, và cộng thêm thành phần FAKE trên
    private UserService userService;

    @Test
    public void createUser_shouldReturUser_WhenEmailValid() {
        // arange:Chuẩn bị
        User inputUser = new User(null, "Vũ Duy", "vuduy@gmail.com");
        User outputUser = new User(1L, "Bảo Uyên", "uyen@gmail.com");

        when(this.userRepository.existsByEmail(inputUser.getEmail())).thenReturn(false); // Fake data

        when(this.userRepository.save(any())).thenReturn(outputUser); // Fake data
        // act: Hành động
        User result = this.userService.createUser(inputUser);

        // assert: so sánh
        assertEquals(1L, result.getId());
    }

}
