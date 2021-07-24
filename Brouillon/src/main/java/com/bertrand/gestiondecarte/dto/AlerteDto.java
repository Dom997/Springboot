package com.bertrand.gestiondecarte.dto;

import com.bertrand.gestiondecarte.model.AbstractEntity;
import com.bertrand.gestiondecarte.model.Alerte;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Data
@Builder

public class AlerteDto extends AbstractEntity
{
    private Integer IdAlerte;

    private String Message;

    private Instant DateCreation;

    //Dto->Entity
    public static AlerteDto fromEtity(Alerte alerte)
    {
        if (alerte == null) {
            return null;
        }

        return AlerteDto.builder()
                .DateCreation(alerte.getDateCreation())
                .Message(alerte.getMessage())
                .build();
    }

    public Alerte toEntity(AlerteDto alerteDto){
        if (alerteDto == null)
        {
            return null;

        }

        Alerte alerte=new Alerte();
        alerte.setIdAlerte(alerteDto.getIdAlerte());
        alerte.setDateCreation(alerteDto.getDateCreation());
        alerte.setMessage(alerteDto.getMessage());
        return alerte;
    }
}
