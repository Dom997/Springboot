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
@Table(name="Carte")
public class Carte extends AbstractEntity
{

    @Column(name ="IdCarte")
    private Integer IdCarte;

    @Column(name ="TypeCarte")
    private TypeDeCarte TypeCarte;

    @Column(name ="DateExpiration")
    private Instant DateExpiration;

    @Column(name ="DateRemise")
    private Instant DateRemise;

    @Column(name ="EtatCartes")
    private EtatCarte EtatCartes;

    @ManyToOne
    @JoinColumn(name = "IdLots")
    private LotDeCarte LotDeCartes;

    @ManyToOne
    @JoinColumn(name = "Clients")
    private Client Clients;


}
