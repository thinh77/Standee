package com.thinh.Standee.dto.response;

import com.thinh.Standee.enums.SiteName;
import lombok.Data;

@Data
public class SiteEntityDto {
    private String id;
    private SiteName name;
}
