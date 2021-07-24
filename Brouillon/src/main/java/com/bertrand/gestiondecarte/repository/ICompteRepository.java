package com.bertrand.gestiondecarte.repository;

import com.bertrand.gestiondecarte.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompteRepository extends JpaRepository <Compte,Integer> {
}
