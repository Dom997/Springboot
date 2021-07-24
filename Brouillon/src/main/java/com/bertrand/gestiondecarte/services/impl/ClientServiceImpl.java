package com.bertrand.gestiondecarte.services.impl;

import com.bertrand.gestiondecarte.dto.ClientDto;
import com.bertrand.gestiondecarte.exception.EntityNotFoundException;
import com.bertrand.gestiondecarte.exception.ErrorCodes;
import com.bertrand.gestiondecarte.exception.InvalidEntityException;
import com.bertrand.gestiondecarte.model.Client;
import com.bertrand.gestiondecarte.repository.IClientRepository;
import com.bertrand.gestiondecarte.services.IClientService;
import com.bertrand.gestiondecarte.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements IClientService
{
    private IClientRepository iClientRepository;

    @Autowired
    public ClientServiceImpl(IClientRepository iClientRepository) {
        this.iClientRepository = iClientRepository;
    }

    @Override
    public ClientDto save(ClientDto clientDto)
    {
        List<String> errors= ClientValidator.Validate(clientDto);

        if ( !errors.isEmpty())
        {
            log.error("Client non valide {}",clientDto);
            throw new InvalidEntityException("Le Client n'est pas valide", ErrorCodes.CLIENT_NOT_FOUND,errors);
        }

        return clientDto.fromEntity(iClientRepository.save(clientDto.toEntity(clientDto)));
    }

    @Override
    public ClientDto findById(Integer id)
    {
        if (id == null)
        {
            log.error("L'id est incorrecte");
            return null;
        }

        Optional<Client> client=iClientRepository.findById(id);
        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow
                ( ()->new EntityNotFoundException(
                        "Aucun Client correspondant à l'ID=" + id,
                        ErrorCodes.CLIENT_NOT_FOUND
                ));

    }

    @Override
    public List<ClientDto> findAll() {
        return iClientRepository.findAll().stream().map(ClientDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idClient)
    {
        if (idClient== null)
        {
            log.error("L'id du Client est incorrecte");
            return;

        }

        iClientRepository.deleteById(idClient);


    }
}
