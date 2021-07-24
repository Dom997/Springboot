package com.bertrand.gestiondecarte.services;

import com.bertrand.gestiondecarte.dto.UserDto;

import java.util.List;

public interface IUserService
{
    UserDto save(UserDto userDto);

    UserDto findById (Integer id);

   // UserDto findByIdUser( Integer idUser);

    List<UserDto> findAll();

    void delete(Integer id);


}
