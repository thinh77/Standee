package com.thinh.Standee.dto.request;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String email;
    private String password;
}
