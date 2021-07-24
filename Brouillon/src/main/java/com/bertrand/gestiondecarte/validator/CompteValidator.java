package com.bertrand.gestiondecarte.validator;

import com.bertrand.gestiondecarte.dto.CompteDto;

import java.util.ArrayList;
import java.util.List;

public class CompteValidator
{
    public static List<String> Validate(CompteDto compteDto)
    {
        List<String> errors=new ArrayList<>();
        if ( compteDto ==null)
        {
            errors.add("La Compte lot est Null ! veuillez renseigner les champs du lot");
        }

        if (compteDto.getDateCreation() == null)
        {
            errors.add("Veuillez entrez une date valide");

        }


        return errors;

    }
}
