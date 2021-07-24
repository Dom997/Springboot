package com.bertrand.gestiondecarte.repository;

import com.bertrand.gestiondecarte.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Integer>
{
   // Optional<User> findUserByIdUser(Integer idUser);

}
