package com.bertrand.gestiondecarte.services;

import com.bertrand.gestiondecarte.dto.ClientDto;


import java.util.List;

public interface IClientService
{
    ClientDto save(ClientDto clientDto);

    ClientDto findById(Integer id);

    List<ClientDto> findAll();

    void delete(Integer id);
}
