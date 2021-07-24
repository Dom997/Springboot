package com.bertrand.gestiondecarte.dto;

import com.bertrand.gestiondecarte.model.*;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder

public class CarteDto
{
    private Integer id;

    private Integer IdCarte;

    private TypeDeCarte TypeCarte;

    private Instant DateExpiration;

    private Instant DateRemise;

    private EtatCarte EtatCartes;

    private LotDeCarteDto LotDeCartes;

    private ClientDto Clients;

    public static CarteDto fromEntity(Carte carte){
        if (carte == null) {

            return null;
        }

       return CarteDto.builder()
               .IdCarte(carte.getIdCarte())
               .TypeCarte(carte.getTypeCarte())
               .DateExpiration(carte.getDateExpiration())
               .DateRemise(carte.getDateRemise())
               .EtatCartes(carte.getEtatCartes())
               .build();

    }


    public Carte toEntity(CarteDto carteDto){
        if (carteDto == null) {

            return null;
        }
        Carte carte=new Carte();
        carte.setIdCarte(carteDto.getIdCarte());
        carte.setTypeCarte(carteDto.getTypeCarte());
        carte.setDateExpiration(carteDto.getDateExpiration());
        carte.setDateRemise(carteDto.getDateRemise());
        carte.setEtatCartes(carteDto.getEtatCartes());
       return carte;

    }


}
