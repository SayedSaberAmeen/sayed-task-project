package com.sayed.saber.service;

import com.sayed.saber.dto.LoginDto;
import com.sayed.saber.dto.UserDto;
import com.sayed.saber.entity.UserEntity;
import com.sayed.saber.repository.UserRepository;
import com.sayed.saber.util.GeneralUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto register(UserDto dto) {

        return new UserDto(userRepository.save(new UserEntity(dto)));
    }

    public String login(LoginDto loginDto) {

        Optional<UserEntity> loginUser = userRepository.findByUsernameLikeOrEmailLikeAndPassword(
                loginDto.getUsername(),
                loginDto.getUsername(),
                loginDto.getPassword());

        if (loginUser.isPresent()) {
            GeneralUtil.loginUser.put("userName", loginUser.get().getUsername());

            return loginUser.get().getUsername() + "logged in successfully";
        }

        return "username or password in incorrect";

    }
}
