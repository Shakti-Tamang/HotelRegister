package com.microservices.projection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectNumberRoleDto {
    private String roleName;

    private Long count;
}
