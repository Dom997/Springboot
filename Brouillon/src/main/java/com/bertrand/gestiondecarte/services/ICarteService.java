package com.bertrand.gestiondecarte.services;

import com.bertrand.gestiondecarte.dto.CarteDto;

import java.util.List;


public interface ICarteService
{
    CarteDto save(CarteDto carteDto);

    CarteDto findById (Integer id);

    List<CarteDto> findAll();

    void delete(Integer id);
}
