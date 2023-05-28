package com.app.okay.response;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class UserResponse {
    private long userId;
    private String name;
    private String email;
    private String password;
}
