package com.bertrand.gestiondecarte.repository;

import com.bertrand.gestiondecarte.model.Carte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartesRepository extends JpaRepository<Carte, Integer>
{


}
