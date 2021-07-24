package com.bertrand.gestiondecarte.validator;

import com.bertrand.gestiondecarte.dto.AgenceDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Agencevalidator
{
    public static List<String> Validate(AgenceDto agenceDto)
    {
        List<String> errors=new ArrayList<>();
        if ( agenceDto == null)
        {
            errors.add("La référence Agence est Null ! veuillez renseigner les champs de l'agence");
        } else
        {
            if (agenceDto.getDateOuverture() == null)
            {
                errors.add("Veuillez une date pour le champs Date ouverture ");

            }

            if (!(StringUtils.hasLength(agenceDto.getDescription())))
            {
                errors.add(("Veuillez saisir une Description pour l'agence"));

            }
        }



        return errors;

    }
}
