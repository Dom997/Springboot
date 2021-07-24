package com.bertrand.gestiondecarte.model;


import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="User")

public class User extends AbstractEntity
{
   @Column(name = "IdUser")
   private Integer IdUser;

   @Column(name = "UserName")
   private String UserName;

   @Column(name = "Nom")
   private String Nom;

   @Column(name ="Prenom" )
   private String Prenom;

   @Column(name = "MotDePasse")
   private String MotDePasse;

   @Column(name = "DateConnection")
   private Instant DateConnection;

   @Column(name = "DateCreation")
   private Instant DateCreation;

   @Column(name = "Poste")
   private String Poste;

   @Column(name = "Photo")
   private String Photo;

   private Integer id;

   @ManyToOne
   @JoinColumn(name = "AgenceUtilisateurs")
   private Agence AgenceUtilisateur;

   @OneToMany(mappedBy = "Utilisateur")
   private List<Roles> Role;

 }
