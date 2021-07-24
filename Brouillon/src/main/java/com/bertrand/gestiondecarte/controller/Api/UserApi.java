package com.bertrand.gestiondecarte.controller.Api;

import com.bertrand.gestiondecarte.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.bertrand.gestiondecarte.utils.constants.APP_ROOt;
@Api(APP_ROOt + "/Utilisateur")
public interface UserApi
{
    @PostMapping(value = APP_ROOt + "user/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Créer un utilisateur",notes = " Permet d'jouter ou de modifier un article ",response = UserDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200,message = "Lobjet utilisateur créér / modifer"),
            @ApiResponse(code = 400,message = "L'utilisateur n'est pas valide")
    })
    UserDto save(@RequestBody UserDto userDto);

    @GetMapping(value = APP_ROOt + "user/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un utilisateur",notes = "Cette methode permet de rechercher utilisateur",response = UserDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200,message = "Lobjet utilisateur a été trouvez dans la base de donnée"),
            @ApiResponse(code = 404,message = "Aucun utilisateur trouver dans le base de donnée ")
    })
    UserDto findById (@PathVariable Integer id);
/*
    @GetMapping(value = APP_ROOt + "user/{idUser}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher par id de  l'utilisateur",notes = " Permet d'eefectuer une recherche via l'id de l'utilisateur ",response = UserDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200,message = "Utilisateur trouver dans la base de donnée"),
            @ApiResponse(code = 404,message = "Aucun utilisateur trouver dans le base de donnée ")

    })
    UserDto findByIdUser( @PathVariable Integer idUser);*/

    @GetMapping(value = APP_ROOt + "user/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher tout les utilisateurs",notes = " Permet d'afficher la liste de tout les utilisateurs",response = UserDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200,message = " lite des Utilisateurs")
    })
    List<UserDto> findAll();

    @DeleteMapping(value = APP_ROOt + "user/delete/id")
    @ApiOperation(value = "Supprimer un utilisateur ",notes = " Permet de supprimer un utilisateur ",response = UserDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200,message = "Utilisateur supprimer")
    })
    void delete(@PathVariable Integer id);

}
