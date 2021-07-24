package com.bertrand.gestiondecarte.repository;

import com.bertrand.gestiondecarte.model.LotDeCarte;
import com.bertrand.gestiondecarte.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.Optional;

public interface ILotDeCarteRepository extends JpaRepository <LotDeCarte,Integer>
{
    Optional<LotDeCarte> findUserById(Integer idLot);
    //Optional<LotDeCarte> findUserByDate(Instant date);
}
