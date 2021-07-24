package com.bertrand.gestiondecarte.services;

import com.bertrand.gestiondecarte.dto.AgenceDto;

import java.util.List;

public interface IAgenceService
{
    AgenceDto save(AgenceDto agenceDto);

    AgenceDto findById (Integer id);

    List<AgenceDto> findAll();

    void delete(Integer id);
}
