package com.bertrand.gestiondecarte.repository;

import com.bertrand.gestiondecarte.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Roles,Integer> {
}
