package com.bertrand.gestiondecarte.services.impl;

import com.bertrand.gestiondecarte.dto.CompteDto;
import com.bertrand.gestiondecarte.exception.EntityNotFoundException;
import com.bertrand.gestiondecarte.exception.ErrorCodes;
import com.bertrand.gestiondecarte.exception.InvalidEntityException;
import com.bertrand.gestiondecarte.model.Compte;
import com.bertrand.gestiondecarte.repository.ICompteRepository;
import com.bertrand.gestiondecarte.services.IComptesService;
import com.bertrand.gestiondecarte.validator.CompteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CompteServiceImpl implements IComptesService
{
    private ICompteRepository iCompteRepository;

    @Autowired
    public CompteServiceImpl(ICompteRepository compteRepository) {
        this.iCompteRepository = compteRepository;
    }

    @Override
    public CompteDto save(CompteDto compteDto)
    {
        List<String> errors= CompteValidator.Validate(compteDto);

        if ( !errors.isEmpty())
        {
            log.error("Compte non valide {}",compteDto);
            throw new InvalidEntityException("Le Compte n'est pas valide", ErrorCodes.COMPTE_NOT_FOUND,errors);
        }

        return CompteDto.fromEntity(iCompteRepository.save(CompteDto.toEntity(compteDto)));

    }

    @Override
    public CompteDto findById(Integer id)
    {
        if (id == null)
        {
            log.error("L'id est incorrecte");
            return null;

        }

        Optional<Compte> compte=iCompteRepository.findById(id);
        return Optional.of(CompteDto.fromEntity(compte.get())).orElseThrow
                ( ()->new EntityNotFoundException(
                        "Aucun Compte correspondant à l'ID=" + id,
                        ErrorCodes.COMPTE_NOT_FOUND)
                );
    }

    @Override
    public List<CompteDto> findAll()
    {
        return iCompteRepository.findAll().stream().map(CompteDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id)
    {
        if (id == null)
        {
            log.error("L'id de Compte est incorrecte");
            return;

        }

        iCompteRepository.deleteById(id);

    }
}
