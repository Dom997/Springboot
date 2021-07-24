package com.bertrand.gestiondecarte.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Roles")
public class Roles extends AbstractEntity
{
    @Column(name = "RoleName")
    private String RoleName;

    @ManyToOne
    @JoinColumn(name = "Utilisateurs")
    private User Utilisateur;


}
