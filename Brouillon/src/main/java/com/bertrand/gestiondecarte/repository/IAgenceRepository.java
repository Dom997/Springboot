package com.bertrand.gestiondecarte.repository;

import com.bertrand.gestiondecarte.model.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAgenceRepository extends JpaRepository <Agence,Integer> {
}
