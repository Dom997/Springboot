package com.bertrand.gestiondecarte.dto;


import com.bertrand.gestiondecarte.model.Adresse;
import lombok.*;

@Data
@Builder

public class AdresseDto
{
    private Integer id;

    private String Adresse1;

    private String Adresse2;

    private String Ville;

    private String CodePostal;

    private String Pays;

    //Mappage de Entity->Dto
    public AdresseDto fromEntity(Adresse adresse)
    {
        if (adresse == null)
        {
            return null;
        }

        return AdresseDto.builder()
                            .Adresse1(adresse.getAdresse1())
                            .Adresse2(adresse.getAdresse2())
                            .Ville(adresse.getVille())
                            .CodePostal(adresse.getCodePostal())
                            .Pays(adresse.getPays())
                            .build();
    }
    //Mappage de Dto->Entity
    public Adresse toEntity(AdresseDto adresseDto)
    {
        if (adresseDto == null)
        {
            return null;
        }

        Adresse adresse = new Adresse();
        adresse.setAdresse1(adresseDto.getAdresse1());
        adresse.setAdresse2(adresseDto.getAdresse2());
        adresse.setVille(adresseDto.getVille());
        adresse.setCodePostal(adresseDto.getCodePostal());
        adresse.setPays(adresseDto.getPays());
        return adresse;
    }




}
