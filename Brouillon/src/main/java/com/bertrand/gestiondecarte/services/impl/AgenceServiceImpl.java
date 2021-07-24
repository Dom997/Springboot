package com.bertrand.gestiondecarte.services.impl;

import com.bertrand.gestiondecarte.dto.AgenceDto;
import com.bertrand.gestiondecarte.dto.AlerteDto;
import com.bertrand.gestiondecarte.exception.EntityNotFoundException;
import com.bertrand.gestiondecarte.exception.ErrorCodes;
import com.bertrand.gestiondecarte.exception.InvalidEntityException;
import com.bertrand.gestiondecarte.model.Agence;
import com.bertrand.gestiondecarte.model.Alerte;
import com.bertrand.gestiondecarte.repository.IAgenceRepository;
import com.bertrand.gestiondecarte.services.IAgenceService;
import com.bertrand.gestiondecarte.validator.Agencevalidator;
import com.bertrand.gestiondecarte.validator.AlerteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AgenceServiceImpl implements IAgenceService
{
    private IAgenceRepository iAgenceRepository;

    @Autowired
    public AgenceServiceImpl(IAgenceRepository iAgenceRepository) {
        this.iAgenceRepository = iAgenceRepository;
    }


    @Override
    public AgenceDto save(AgenceDto agenceDto)
    {
        List<String> errors= Agencevalidator.Validate(agenceDto);

        if ( !errors.isEmpty())
        {
            log.error("Agence non valide {}",agenceDto);
            throw new InvalidEntityException("L'Agence n'est pas valide", ErrorCodes.AGENCE_NOT_FOUND,errors);
        }

        return agenceDto.fromEntity(iAgenceRepository.save(agenceDto.toEntity(agenceDto)));

    }

    @Override
    public AgenceDto findById(Integer id) {

        if (id == null)
        {
            log.error("L'id est incorrecte");
            return null;
        }

        Optional<Agence> agence=iAgenceRepository.findById(id);
        return Optional.of(AgenceDto.fromEntity(agence.get())).orElseThrow
                ( ()->new EntityNotFoundException(
                        "Aucune Agence correspondant à l'ID=" + id,
                        ErrorCodes.AGENCE_NOT_FOUND
                ));

    }

    @Override
    public List<AgenceDto> findAll() {
        return iAgenceRepository.findAll().stream().map(AgenceDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id)
    {
        if (id== null)
        {
            log.error("L'id de l'agence est incorrecte");
            return;

        }

        iAgenceRepository.deleteById(id);

    }
}
