package com.bertrand.gestiondecarte.model;


import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="Agence")

public class Agence extends AbstractEntity
{
    @Column(name ="IdAgence")
    private Integer IdAgence;

    @Column(name = "DateOuverture")
    private Instant DateOuverture;

    @Column(name ="Description")
    private String Description;
    @Column(name = "Adresse")
    private Adresse Adresses;

    @OneToMany(mappedBy ="Agences")
    private List<Compte> Comptes;

    @OneToMany(mappedBy ="AgenceUtilisateur")
    private List<User> userList;

    @OneToMany(mappedBy ="Agences")
    private List<Client> Clients;

    @ManyToOne
    @JoinColumn(name = "ClientList")
    private Client ClientList;
}