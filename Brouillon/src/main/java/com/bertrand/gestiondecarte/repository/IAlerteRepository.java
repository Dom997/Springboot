package com.bertrand.gestiondecarte.repository;

import com.bertrand.gestiondecarte.model.Alerte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlerteRepository extends JpaRepository <Alerte,Integer> {
}
