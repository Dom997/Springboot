package com.bertrand.gestiondecarte.services.impl;

import com.bertrand.gestiondecarte.dto.UserDto;
import com.bertrand.gestiondecarte.exception.EntityNotFoundException;
import com.bertrand.gestiondecarte.exception.ErrorCodes;
import com.bertrand.gestiondecarte.exception.InvalidEntityException;
import com.bertrand.gestiondecarte.model.User;
import com.bertrand.gestiondecarte.repository.IUserRepository;
import com.bertrand.gestiondecarte.services.IUserService;
import com.bertrand.gestiondecarte.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceServiceImpl implements IUserService
{
    private IUserRepository iUserRepository;

    @Autowired
    public UserServiceServiceImpl(IUserRepository userRepository)
    {
        this.iUserRepository=userRepository;
    }

    @Override
    public UserDto save(UserDto userDto)
    {
        List<String> errors= UserValidator.Validate(userDto);

        if ( !errors.isEmpty())
        {
            log.error("Utilisateur non valide {}",userDto);
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_FOUND,errors);
        }

        return userDto.fromEntity(iUserRepository.save(userDto.toEntity(userDto)));
    }

    @Override
    public UserDto findById(Integer id)
    {
        if (id == null)
        {
            log.error("L'id est incorrecte");
            return null;

        }

        Optional<User> user=iUserRepository.findById(id);
        return Optional.of(UserDto.fromEntity(user.get())).orElseThrow
                ( ()->new EntityNotFoundException(
                        "Aucun utilisateur correspondant à l'ID=" + id,
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
    }

   /* @Override
    public UserDto findByIdUser(Integer idUser)
    {
        if (idUser == null)
        {
            log.error("L'id de l'utilisateur est incorrecte");
            return null;

        }

        Optional<User> user=iUserRepository.findUserByIdUser(idUser);
        return Optional.of(UserDto.fromEntity(user.get())).orElseThrow
                ( ()->new EntityNotFoundException(
                        "Aucun utilisateur correspondant à l'ID=" + idUser,
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
                );
    }
*/
    @Override
    public List<UserDto> findAll() {
        return iUserRepository.findAll().stream().map(UserDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null)
        {
            log.error("L'id de l'utilisateur est incorrecte");
            return;

        }

        iUserRepository.deleteById(id);

    }
}
