package com.app.okay.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private long userId;

    @NotBlank
    private String name;

    @Email
    @NotNull
    private String email;

    @NotBlank
    private String password;
}
