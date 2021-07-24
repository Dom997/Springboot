package com.bertrand.gestiondecarte.services;

import com.bertrand.gestiondecarte.dto.AlerteDto;

import java.util.List;

public interface IAlerteService
{
    AlerteDto save(AlerteDto alerteDto);

    AlerteDto findById (Integer id);

    List<AlerteDto> findAll();

    void delete(Integer id);
}
