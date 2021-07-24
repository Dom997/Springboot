package com.bertrand.gestiondecarte.repository;


import com.bertrand.gestiondecarte.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IClientRepository extends JpaRepository <Client, Integer>
{

}
