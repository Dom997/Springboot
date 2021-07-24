package com.bertrand.gestiondecarte.validator;

import com.bertrand.gestiondecarte.dto.RolesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RoleValidator
{

    public static List<String> Validate(RolesDto rolesDto )
    {
        List<String> errors=new ArrayList<>();

        if ( rolesDto ==null)
        {
            errors.add("La référence role est Null ! veuillez renseigner les champs du role");
        }

        if ((!(StringUtils.hasLength(rolesDto.getRoleName()))))
        {
            errors.add("Veuillez renseigner le nom du role : ");
        }

        if ( rolesDto.getUtilisateur() ==null)
        {
            errors.add("La référence utilisateur du champs role est null ");
        }

        return errors;

    }
}
