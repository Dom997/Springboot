package com.bertrand.gestiondecarte.services.impl;

import com.bertrand.gestiondecarte.dto.CarteDto;
import com.bertrand.gestiondecarte.dto.UserDto;
import com.bertrand.gestiondecarte.exception.EntityNotFoundException;
import com.bertrand.gestiondecarte.exception.ErrorCodes;
import com.bertrand.gestiondecarte.exception.InvalidEntityException;
import com.bertrand.gestiondecarte.model.Carte;
import com.bertrand.gestiondecarte.model.Client;
import com.bertrand.gestiondecarte.repository.ICartesRepository;
import com.bertrand.gestiondecarte.repository.IClientRepository;
import com.bertrand.gestiondecarte.services.ICarteService;
import com.bertrand.gestiondecarte.validator.CarteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CarteServiceImpl implements ICarteService
{
    private ICartesRepository iCartesRepository;
    private IClientRepository iClientRepository;

    @Autowired
    public CarteServiceImpl(ICartesRepository iCartesRepository,IClientRepository iClientRepository) {
        this.iCartesRepository = iCartesRepository;
        this.iClientRepository=iClientRepository;
    }


    @Override
    public CarteDto save(CarteDto carteDto)
    {
        List<String> errors= CarteValidator.Validate(carteDto);

        if ( !errors.isEmpty())
        {
            log.error("Carte non valide {}",carteDto);
            throw new InvalidEntityException("La carte n'est pas valide", ErrorCodes.CARTE_NOT_FOUND,errors);
        }

        Optional<Client> client= iClientRepository.findById(carteDto.getClients().getId());
        if (!client.isPresent())
        {
            log.warn("L'id {} client n'existe pas dans la base de donnée",carteDto.getClients().getId());
            throw new EntityNotFoundException("Aucun client avec l'id" + carteDto.getClients().getId() + "Trouver dans la base de données",ErrorCodes.CLIENT_NOT_FOUND);
        }
        return carteDto.fromEntity(iCartesRepository.save(carteDto.toEntity(carteDto)));
    }

    @Override
    public CarteDto findById(Integer id)
    {

        if (id == null)
        {
            log.error("L'id est incorrecte");
            return null;

        }

        Optional<Carte> carte=iCartesRepository.findById(id);
        return Optional.of(CarteDto.fromEntity(carte.get())).orElseThrow
                ( ()->new EntityNotFoundException(
                        "Aucune Carte correspondant à l'ID=" + id,
                        ErrorCodes.CARTE_NOT_FOUND)
                );
    }

    @Override
    public List<CarteDto> findAll() {
        return iCartesRepository.findAll().stream().map(CarteDto::fromEntity).collect(Collectors.toList());    }

    @Override
    public void delete(Integer id)
    {
        if (id == null)
        {
            log.error("L'id de la Carte est incorrecte");
            return;

        }

        iCartesRepository.deleteById(id);


    }
}
