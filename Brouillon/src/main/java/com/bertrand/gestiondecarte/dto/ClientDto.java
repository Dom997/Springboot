package com.bertrand.gestiondecarte.dto;


import com.bertrand.gestiondecarte.model.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.Instant;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder


public class ClientDto extends AbstractEntity
{
    private Integer id;

    private Integer IdClient;

    private String Nom;

    private  String Prenom;

    private Instant DateNaissance;

    private String Profession;

    private String Mail;

    private String NumeroTel;

    private String Photo;

    private AdresseDto Adresses;

    @JsonIgnore
    private List<CarteDto> Cartes;

    @JsonIgnore
    private List<CompteDto> Comptes;

    @JsonIgnore
    private List<AgenceDto> agenceList;

    private AgenceDto Agences;

    public static ClientDto fromEntity(Client client)
    {
        if (client == null)
        {
            return null;
        }

        return ClientDto.builder()
                .id(client.getId())
                .IdClient(client.getIdClient())
                .Nom(client.getNom())
                .Prenom(client.getPrenom())
                .DateNaissance(client.getDateNaissance())
                .Profession(client.getProfession())
                .Mail(client.getMail())
                .NumeroTel(client.getNumeroTel())
                .Photo(client.getPhoto())
                .build();
    }
    public Client toEntity(ClientDto clientDto)
    {
        if (clientDto == null)
        {
            return null;
        }
        Client client=new Client();
        client.setId(clientDto.getId());
        client.setIdClient(clientDto.getIdClient());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setDateNaissance(clientDto.getDateNaissance());
        client.setProfession(clientDto.getProfession());
        client.setMail(clientDto.getMail());
        client.setNumeroTel(clientDto.getNumeroTel());
        client.setPhoto(clientDto.getPhoto());
        return client;
    }
}
