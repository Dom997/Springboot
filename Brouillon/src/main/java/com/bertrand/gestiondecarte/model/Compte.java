package com.bertrand.gestiondecarte.model;


import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="Compte")

public class Compte extends AbstractEntity{

    @Column(name = "IdCompte")
    private Integer IdCompte;

    @Column(name = "DateCreation")
    private Instant DateCreation;

    @Column(name = "TypeCompte")
    private TypeDeCompte TypeCompte;

    @ManyToOne
    @JoinColumn(name ="IdAgence")
    private Agence Agences;

    @ManyToOne
    @JoinColumn(name ="IdClient")
    private Client Clients;


}
