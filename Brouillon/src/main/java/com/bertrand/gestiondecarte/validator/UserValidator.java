package com.bertrand.gestiondecarte.validator;

import com.bertrand.gestiondecarte.dto.UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator
{
    public static List<String> Validate(UserDto userDto )
    {
        List<String> errors=new ArrayList<>();

        if (userDto== null) {
            errors.add("Veuillez renseigner le nom de l'utilisateur : ");
            errors.add("Veuillez renseigner le prénom de l'utilisateur : ");
            errors.add("Veuillez renseigner le nom d'utilisateur : ");
            errors.add("Veuillez renseigner le mot de passe: ");
            errors.add("Veuillez renseigner le poste occupé : ");
        }
        //validation du nom
        if (!(StringUtils.hasLength(userDto.getNom())))
        {
            errors.add("Veuillez renseigner le nom de l'utilisateur : ");
        }
        //Validation du prénom
        if (!(StringUtils.hasLength(userDto.getPrenom())))
        {
            errors.add("Veuillez renseigner le prénom de l'utilisateur : ");
        }

        //Validation du Nom d'utilisateur
        if (!(StringUtils.hasLength(userDto.getUserName())))
        {
            errors.add("Veuillez renseigner le nom d'utilisateur de l'utilisateur : ");
        }

        //Validation du mot de passe
        if (!(StringUtils.hasLength(userDto.getMotDePasse())))
        {
            errors.add("Veuillez renseigner un mot de passe : ");
        }

        //Validation du poste
        if (!(StringUtils.hasLength(userDto.getPoste())))
        {
            errors.add("Veuillez renseigner  le poste occupé : ");
        }
        return errors;

    }
}
