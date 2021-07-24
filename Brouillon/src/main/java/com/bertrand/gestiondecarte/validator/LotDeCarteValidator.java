package com.bertrand.gestiondecarte.validator;

import com.bertrand.gestiondecarte.dto.LotDeCarteDto;

import java.util.ArrayList;
import java.util.List;

public class LotDeCarteValidator
{
    public static List<String> Validate(LotDeCarteDto lotDeCarteDto)
    {
        List<String> errors=new ArrayList<>();
        if ( lotDeCarteDto ==null || lotDeCarteDto.getNombreDeCarte()==0)
        {
            errors.add("La référence lot est Null ! veuillez renseigner les champs du lot");
        }

        if (lotDeCarteDto.getNombreDeCarte() == 0)
        {
            errors.add("Veuillez renseigner le nombre de cartes du lot ");
        }

        if (lotDeCarteDto.getDateProduction() == null)
        {
            errors.add("Veuillez renseigner la date de production :");

        }

        return errors;

    }
}
