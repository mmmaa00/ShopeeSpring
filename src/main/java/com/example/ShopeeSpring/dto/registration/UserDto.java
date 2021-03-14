package com.example.ShopeeSpring.dto.registration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String password;


    public UserDto(@NotNull @NotEmpty String name, @NotNull @NotEmpty String email, @NotNull @NotEmpty String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
