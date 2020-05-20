package ru.itis.sem1.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDto {

    @NotBlank
    @Email(message = "Майл введен некорректно")
    public String email;
    @NotBlank(message = "Имя не может быть пустым")
    public String name;
    @NotBlank
    @Min(value = 3, message = "Пароль должен состоять минимум из 3х символов")
    public String password;

}