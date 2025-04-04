package com.thinh.Standee.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocationDto {
    private String id;
    private String name;
    private SiteEntityDto site;
}
