package com.bertrand.gestiondecarte.dto;

import com.bertrand.gestiondecarte.model.Roles;
import lombok.*;

@Data
@Builder
public class RolesDto
{
    private Integer id;

    private String RoleName;

    private UserDto Utilisateur;

   public RolesDto fromEntity(Roles roles){
       if (roles == null)
       {
           return null;

       }

       return RolesDto.builder()
               .id(roles.getId())
               .RoleName(roles.getRoleName())
               .build();
   }

   public RolesDto toEntity(RolesDto rolesDto){
       if (rolesDto == null)
       {
           return null;

       }
       
       return RolesDto.builder()
               .id(rolesDto.getId())
               .RoleName(rolesDto.getRoleName())
               .build();
   }
}
