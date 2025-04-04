package com.thinh.Standee.dto.response;

import com.thinh.Standee.enums.RoleName;
import lombok.Data;

@Data
public class RoleDto {
    private Long id;
    private RoleName name;
}
