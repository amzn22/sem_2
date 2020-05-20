package ru.itis.sem1.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    public UserDto(Long id) {
        this.id = id;
    }

    public UserDto(String username) {
        this.username = username;
    }

    public UserDto(String username, Long id) {
        this.username = username;
        this.id = id;
    }

    public UserDto() {
    }

    private String username;
    private Long id;
}