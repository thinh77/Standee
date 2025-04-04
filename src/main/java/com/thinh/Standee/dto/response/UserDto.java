package com.thinh.Standee.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thinh.Standee.enums.RoleName;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private String id;
    private String email;
    private String username;
    private String phone;
    private String unit;
    private RoleName role;
    private List<LocationDto> locations = new ArrayList<>();
}
