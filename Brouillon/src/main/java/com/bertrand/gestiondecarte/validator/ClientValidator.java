package com.bertrand.gestiondecarte.validator;

import com.bertrand.gestiondecarte.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator
{
    public static List<String> Validate(ClientDto clientDto)
    { List<String> errors=new ArrayList<>();

        if (clientDto == null)
        {
            errors.add("Veuillez rensigner le nom :");
            errors.add("Veuiller renseigner le prenom :");
            errors.add("Veuiller renseigner la date de naissance :");
            errors.add("Veuiller renseigner la profession :");
            errors.add("Veuiller renseigner l'adresse mail :");
            errors.add("Veuiller renseigner numéro de téléphone :");
            errors.add("Veuiller renseigner l'adresse :");
            errors.add("Veuiller renseigner l'agence :");
        }

        if (!(StringUtils.hasLength(clientDto.getNom())))
        {
            errors.add("Veuiller renseigner le nom :");
        }

        if (!(StringUtils.hasLength(clientDto.getPrenom())))
        {
            errors.add("Veuiller renseigner le prenom :");
        }

        if (clientDto.getDateNaissance() == null)
        {
            errors.add("Veuiller renseigner la date de naissance :");
        }

        if(!(StringUtils.hasLength(clientDto.getProfession())))
        {
            errors.add("Veuiller renseigner la profession :");
        }

        if (!(StringUtils.hasLength(clientDto.getMail())))
        {
            errors.add("Veuiller renseigner l'adresse mail :");
        }

        if (!(StringUtils.hasLength(clientDto.getNumeroTel())))
        {
            errors.add("Veuiller renseigner numéro de téléphone :");
        }

        if (clientDto.getAdresses() == null)
        {
            errors.add("Veuiller renseigner les champs de l'adresse :");
        }
        else
        {
            if (!(StringUtils.hasLength(clientDto.getAdresses().getAdresse1())))
            {
                errors.add("Le champ Adresse 1 est obligatoire :");

            }

            if (!(StringUtils.hasLength(clientDto.getAdresses().getVille())))
            {
                errors.add("Le champ Ville est obligatoire :");

            }

            if (!(StringUtils.hasLength(clientDto.getAdresses().getCodePostal())))
            {
                errors.add("Le champ Code postal est obligatoire :");

            }

            if (!(StringUtils.hasLength(clientDto.getAdresses().getPays())))
            {
                errors.add("Le champ Pays est obligatoire :");

            }
        }

        if (clientDto.getAgences() == null)
        {
            errors.add("Veuiller renseigner l'agence :");
        }

        return errors;
    }
}
