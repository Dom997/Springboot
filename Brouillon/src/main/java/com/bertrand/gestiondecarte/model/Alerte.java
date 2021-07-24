package com.bertrand.gestiondecarte.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="Alerte")

public class Alerte extends AbstractEntity
{
    @Column(name = "IdAlerte")
    private Integer IdAlerte;

    @Column(name = "Message")
    private String Message;

    @Column(name = "DateCreation")
     private Instant DateCreation;
}
