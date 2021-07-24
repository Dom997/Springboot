package com.bertrand.gestiondecarte.dto;


import com.bertrand.gestiondecarte.model.LotDeCarte;
import com.bertrand.gestiondecarte.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder

public class LotDeCarteDto
{
    private Integer id;

    private Integer IdLot;

    private Instant DateProduction;

    private long NombreDeCarte;

    @JsonIgnore
    private List<CarteDto> Cartes;

    // Function de gestion de Mappage de Entity -> Dto
    public static LotDeCarteDto fromEntity (LotDeCarte lotDeCarte){
        if (lotDeCarte == null)
        {
            return null;
        }

        return LotDeCarteDto.builder()
                                .id(lotDeCarte.getId())
                                .IdLot(lotDeCarte.getIdLot())
                                .DateProduction(lotDeCarte.getDateProduction())
                                .NombreDeCarte(lotDeCarte.getNombreDeCarte())
                                 .build();
    }

    // Function de gestion de Mappage de Dto -> Entity

    public static LotDeCarte toEntity(LotDeCarteDto lotDeCarteDto){
        if (lotDeCarteDto == null)
        {
            return null;
        }

        LotDeCarte lotDeCartes =new LotDeCarte();
        lotDeCartes.setIdLot(lotDeCarteDto.getIdLot());
        lotDeCartes.setNombreDeCarte(lotDeCarteDto.getNombreDeCarte());
        lotDeCartes.setDateProduction(lotDeCarteDto.getDateProduction());
        return lotDeCartes;

    }

}
