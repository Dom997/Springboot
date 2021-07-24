package com.bertrand.gestiondecarte.controller;

import com.bertrand.gestiondecarte.controller.Api.UserApi;
import com.bertrand.gestiondecarte.dto.UserDto;
import com.bertrand.gestiondecarte.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi
{
    private IUserService iUserService;

    @Autowired
    public UserController(IUserService iUserService)
    {
        this.iUserService=iUserService;
    }

    @Override
    public UserDto save(UserDto userDto) {
        return iUserService.save((userDto));
    }

    @Override
    public UserDto findById(Integer id) {
        return iUserService.findById(id);
    }
/*
    @Override
    public UserDto findByIdUser(Integer idUser) {
        return iUserService.findByIdUser(idUser);
    }
*/
    @Override
    public List<UserDto> findAll() {
        return iUserService.findAll();
    }

    @Override
    public void delete(Integer id) {
        iUserService.delete(id);
    }
}
