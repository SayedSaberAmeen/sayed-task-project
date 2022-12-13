package com.sayed.saber.dto;

import com.sayed.saber.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class UserDto {

    private int id;
    private String username;
    private String password;
    private String email;

    public UserDto(UserEntity entity) {

        this.id = entity.getId();
        this.username = entity.getUsername();
        this.password = entity.getPassword();
        this.email = entity.getEmail();
    }
}
