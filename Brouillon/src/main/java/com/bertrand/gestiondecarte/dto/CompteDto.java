package com.bertrand.gestiondecarte.dto;


import com.bertrand.gestiondecarte.model.Compte;
import lombok.*;

import java.time.Instant;

@Data
@Builder

public class CompteDto {

    private Integer id;

    private Integer IdCompte;

    private Instant DateCreation;

    private String TypeCompte;

    private AgenceDto Agences;

    private ClientDto Clients;

    public static CompteDto fromEntity(Compte compte)
    {
        if (compte == null)
        {
            return null;

        }

        return CompteDto.builder()
                .id(compte.getId())
                .IdCompte(compte.getIdCompte())
                .DateCreation(compte.getDateCreation())
                .build();

    }

    public static Compte toEntity(CompteDto compteDto)
    {
        if (compteDto == null)
        {
            return null;

        }
        Compte compte=new Compte();
        compte.setIdCompte(compteDto.getIdCompte());
        compte.setId(compteDto.getId());
        compte.setDateCreation(compteDto.getDateCreation());
        return compte;

    }


}
