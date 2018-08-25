package com.nekisse.myweb.service;

import com.nekisse.myweb.domain.user.User;
import com.nekisse.myweb.domain.user.UserRepository;
import com.nekisse.myweb.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
@Transactional
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;

    public void addUser(UserDto userDto) {
        User user = User.builder()
                .userId(userDto.getUserId())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .build();
        userRepository.save(user);
    }

    public String getUser(String userId, String password, HttpSession session) {
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            return "redirect:/login";
        }
        if (!password.equals(user.getPassword())) {
            return "redirect:login";
        }
        session.setAttribute("user", user);
        return null;
    }






}
