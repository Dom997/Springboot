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
@Table(name="Client")

public class Client extends AbstractEntity
{
    @Column(name = "IdClient")
    private Integer IdClient;

    @Column(name = "Nom")
    private String Nom;

    @Column(name = "Prenom")
    private  String Prenom;

    @Column(name = "DateNaissance")
    private Instant DateNaissance;

    @Column(name = "Profession")
    private String Profession;

    @Column(name = "Mail")
    private String Mail;

    @Column(name = "NumeroTel")
    private String NumeroTel;

    @Column(name = "Photo")
    private String Photo;

    @Embedded
    private Adresse Adresses;

    @OneToMany(mappedBy = "Clients")
    private List<Carte> Cartes;

    @OneToMany(mappedBy = "Clients")
    private List<Compte> Comptes;

    @OneToMany(mappedBy ="ClientList")
    private List<Agence> agenceList;

    @ManyToOne
    @JoinColumn(name = "Agences")
    private Agence Agences;
}
