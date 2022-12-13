package com.sayed.saber.controller;


import com.sayed.saber.dto.LoginDto;
import com.sayed.saber.dto.UserDto;
import com.sayed.saber.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {

        return  ResponseEntity.ok().body( userService.register(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody LoginDto loginDto) {

        return  ResponseEntity.ok().body( userService.login(loginDto));
    }
}
