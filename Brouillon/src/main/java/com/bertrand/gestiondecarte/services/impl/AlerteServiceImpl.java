package com.bertrand.gestiondecarte.services.impl;

import com.bertrand.gestiondecarte.dto.AlerteDto;
import com.bertrand.gestiondecarte.dto.ClientDto;
import com.bertrand.gestiondecarte.exception.EntityNotFoundException;
import com.bertrand.gestiondecarte.exception.ErrorCodes;
import com.bertrand.gestiondecarte.exception.InvalidEntityException;
import com.bertrand.gestiondecarte.model.Alerte;
import com.bertrand.gestiondecarte.model.Client;
import com.bertrand.gestiondecarte.repository.IAlerteRepository;
import com.bertrand.gestiondecarte.services.IAlerteService;
import com.bertrand.gestiondecarte.validator.AlerteValidator;
import com.bertrand.gestiondecarte.validator.CarteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AlerteServiceImpl implements IAlerteService
{
    private IAlerteRepository iAlerteRepository;

    @Autowired
    public AlerteServiceImpl(IAlerteRepository iAlerteRepository) {
        this.iAlerteRepository = iAlerteRepository;
    }


    @Override
    public AlerteDto save(AlerteDto alerteDto) {
        List<String> errors= AlerteValidator.Validate(alerteDto);

        if ( !errors.isEmpty())
        {
            log.error("Alerte non valide {}",alerteDto);
            throw new InvalidEntityException("L'Alerte n'est pas valide", ErrorCodes.CARTE_NOT_FOUND,errors);
        }

        return alerteDto.fromEtity(iAlerteRepository.save(alerteDto.toEntity(alerteDto)));
    }

    @Override
    public AlerteDto findById(Integer id) {
        if (id == null)
        {
            log.error("L'id est incorrecte");
            return null;
        }

        Optional<Alerte> alerte=iAlerteRepository.findById(id);
        return Optional.of(AlerteDto.fromEtity(alerte.get())).orElseThrow
                ( ()->new EntityNotFoundException(
                        "Aucune Alerte correspondant à l'ID=" + id,
                        ErrorCodes.ALERTE_NOT_FOUND
                ));
    }

    @Override
    public List<AlerteDto> findAll() {
        return iAlerteRepository.findAll().stream().map(AlerteDto::fromEtity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id)
    {
        if (id== null)
        {
            log.error("L'id de l'alerte est incorrecte");
            return;

        }

        iAlerteRepository.deleteById(id);

    }
}
