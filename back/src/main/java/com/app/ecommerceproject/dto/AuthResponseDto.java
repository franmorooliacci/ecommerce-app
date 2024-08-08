package com.app.ecommerceproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponseDto {
    private String username;
    private String token;
    private String tokenType = "Bearer ";

    public AuthResponseDto(String username, String token) {
        this.username = username;
        this.token = token;
    }
}
