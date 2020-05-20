package ru.itis.sem1.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class UserDto {
    public UserDto(Long id) {
        this.id = id;
    }

    public UserDto(String name) {
        this.name = name;
    }

    public UserDto(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public UserDto() {
    }

    private String name;
    private Long id;
}