package com.sayed.saber.entity;

import com.sayed.saber.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "users")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private String email;

    public UserEntity(UserDto dto) {

        this.id = dto.getId();
        this.username = dto.getUsername();
        this.password = dto.getPassword();
        this.email = dto.getEmail();
    }


}
