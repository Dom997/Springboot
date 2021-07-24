package com.bertrand.gestiondecarte.validator;

import com.bertrand.gestiondecarte.dto.CarteDto;
import com.bertrand.gestiondecarte.dto.LotDeCarteDto;

import java.util.ArrayList;
import java.util.List;

public class CarteValidator
{
   public static List<String> Validate(CarteDto carteDto)
    {
        List<String> errors=new ArrayList<>();

        if (carteDto==null)
        {
           errors.add("La référence lot est Null,veuillez renseigner les champs du lot");
        }
       return errors;

    }
}
