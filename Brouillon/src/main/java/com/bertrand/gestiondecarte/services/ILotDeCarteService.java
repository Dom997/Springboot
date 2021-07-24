package com.bertrand.gestiondecarte.services;

import com.bertrand.gestiondecarte.dto.LotDeCarteDto;

import java.time.Instant;
import java.util.List;

public interface ILotDeCarteService
{
    LotDeCarteDto save(LotDeCarteDto lotDeCarteDto);

    LotDeCarteDto findById (Integer idLot);

    //LotDeCarteDto findByDate(Instant date);

    List<LotDeCarteDto> findAll();

    void delete(Integer idLot);
}
