package com.thinh.Standee.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thinh.Standee.enums.RoleName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUserRequest {
    @Email
    private String email;
    private String username;
    @Pattern(regexp = "^0[1-9][0-9]{8}$", message = "Phone number must be 10 digits and start with 0")
    private String phone;
    private String unit;
    private RoleName role;
    private String siteId;
    private List<String> locationIds = new ArrayList<>();
}
