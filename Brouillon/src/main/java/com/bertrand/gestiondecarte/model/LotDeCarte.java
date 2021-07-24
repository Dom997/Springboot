package com.bertrand.gestiondecarte.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="LotDeCarte")

public class LotDeCarte extends AbstractEntity
{
    @Column(name = "IdLot")
    private Integer IdLot;

   @Column(name = "DateProduction")
    private Instant DateProduction;

   @Column(name = "NombreDeCarte")
    private long NombreDeCarte;

    @OneToMany(mappedBy ="LotDeCartes")
    private List<Carte> Cartes;

}
