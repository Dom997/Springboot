package com.bertrand.gestiondecarte.dto;


import com.bertrand.gestiondecarte.model.Agence;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
@Data
@Builder
public class AgenceDto
{
    private Integer id;

    private Integer IdAgence;

    private Instant DateOuverture;

    private String Description;

    @JsonIgnore
    private List<CompteDto> Comptes;

    @JsonIgnore
    private List<UserDto> userList;

    @JsonIgnore
    private List<ClientDto> Clients;

    @JsonIgnore
    private ClientDto ClientList;

    //Mappage Entity->DTo
    public static AgenceDto fromEntity(Agence agence)
    {
        if (agence == null)
        {
            return  null;

        }

       return AgenceDto.builder().DateOuverture(agence.getDateOuverture())
                                    .Description(agence.getDescription())
                                    .IdAgence(agence.getIdAgence())
                                    .build();
    }

    //Mappage  DTo-> Entity
    public Agence toEntity(AgenceDto agenceDto)
    {
        if (agenceDto == null)
        {
            return null;

        }

        Agence agence = new Agence();
        agence.setIdAgence(agenceDto.getIdAgence());
        agence.setDateOuverture(agenceDto.getDateOuverture());
        agence.setDescription(agenceDto.getDescription());
       return agence;
    }


}