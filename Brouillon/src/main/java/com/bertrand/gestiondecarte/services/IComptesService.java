package com.bertrand.gestiondecarte.services;

import com.bertrand.gestiondecarte.dto.CompteDto;

import java.util.List;

public interface IComptesService
{
    CompteDto save(CompteDto compteDto);

    CompteDto findById (Integer id);

    List<CompteDto> findAll();

    void delete(Integer id);
}
