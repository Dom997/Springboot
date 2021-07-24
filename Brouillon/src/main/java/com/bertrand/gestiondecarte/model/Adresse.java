package com.bertrand.gestiondecarte.model;


import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name="Adresse")
@Embeddable

public class Adresse
{
    @Column(name = "Adresse1")
    private String Adresse1;

    @Column(name = "Adresse2")
    private String Adresse2;

    @Column(name = "Ville")
    private String Ville;

    @Column(name = "CodePostal")
    private String CodePostal;

    @Column(name = "Pays")
    private String Pays;
}
