package com.bertrand.gestiondecarte.dto;


import com.bertrand.gestiondecarte.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder

public class UserDto
{
   private Integer id;

   private Integer IdUser;

   private String UserName;

   private String Nom;

   private String Prenom;

   private String MotDePasse;

   private Instant DateConnection;

   private Instant DateCreation;

   private String Poste;

   private String Photo;

   private AgenceDto AgenceUtilisateur;

   @JsonIgnore
   private List<RolesDto> Role;

   public static UserDto fromEntity(User user){
      if (user == null)
      {
         return null;

      }
      return UserDto.builder()
              .id(user.getId())
              .IdUser(user.getIdUser())
              .UserName(user.getUserName())
              .Nom(user.getNom())
              .Prenom(user.getPrenom())
              .MotDePasse(user.getMotDePasse())
              .DateConnection(user.getDateConnection())
              .DateCreation(user.getDateCreation())
              .Poste(user.getPoste())
              .Photo(user.getPhoto())
              .build();
   }

   public User toEntity(UserDto userDto){
      if (userDto == null)
      {
         return null;

      }
      User user=new User();
      user.setIdUser(userDto.getIdUser());
      return user;
   }

 }
