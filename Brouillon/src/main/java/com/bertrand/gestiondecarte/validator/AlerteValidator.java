package com.bertrand.gestiondecarte.validator;

import com.bertrand.gestiondecarte.dto.AlerteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AlerteValidator
{
    public static List<String> Validate(AlerteDto alerteDto) {
        List<String> errors = new ArrayList<>();
        if (alerteDto == null) {
            errors.add("La référence Role est Null ! veuillez renseigner les champs du role");
        } else
        {
            if (!(StringUtils.hasLength(alerteDto.getMessage())))
            {
                errors.add("Veuillez renseigner le Message l'alerte");
            }

            if (alerteDto.getDateCreation() == null)
            {
                errors.add("Veuillez renseigner une date :");

            }
        }


        return errors;
    }
}
