package com.bertrand.gestiondecarte.services.impl;

import com.bertrand.gestiondecarte.dto.LotDeCarteDto;
import com.bertrand.gestiondecarte.exception.EntityNotFoundException;
import com.bertrand.gestiondecarte.exception.ErrorCodes;
import com.bertrand.gestiondecarte.exception.InvalidEntityException;
import com.bertrand.gestiondecarte.model.LotDeCarte;
import com.bertrand.gestiondecarte.repository.ILotDeCarteRepository;
import com.bertrand.gestiondecarte.services.ILotDeCarteService;
import com.bertrand.gestiondecarte.validator.LotDeCarteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.time.Instant;

@Service
@Slf4j
public class LotDeCarteServiceImpl implements ILotDeCarteService
{
    private ILotDeCarteRepository iLotDeCarteRepositorys;

    @Autowired
    public LotDeCarteServiceImpl(ILotDeCarteRepository iLotDeCarteRepository) {
        this.iLotDeCarteRepositorys = iLotDeCarteRepository;
    }


    @Override
    public LotDeCarteDto save(LotDeCarteDto lotDeCarteDto)
    {
            List<String> errors= LotDeCarteValidator.Validate(lotDeCarteDto);

            if ( !errors.isEmpty())
            {
                log.error("Lot non valide {}",lotDeCarteDto);
                throw new InvalidEntityException("Lot de carte n'est pas valide", ErrorCodes.LOTDECARTE_NOT_FOUND,errors);
            }

            return LotDeCarteDto.fromEntity(iLotDeCarteRepositorys.save(LotDeCarteDto.toEntity(lotDeCarteDto)));
        }


    @Override
    public LotDeCarteDto findById(Integer idLot) {
        if (idLot == null)
        {
            log.error("L'id est incorrecte");
            return null;
        }

        Optional<LotDeCarte> lotDeCarte=iLotDeCarteRepositorys.findById(idLot);
        return Optional.of(LotDeCarteDto.fromEntity(lotDeCarte.get())).orElseThrow
                ( ()->new EntityNotFoundException(
                        "Aucun Lot correspondant à l'ID=" + idLot,
                        ErrorCodes.LOTDECARTE_NOT_FOUND
                ));
    }

   /* @Override
    public LotDeCarteDto findByDate(Instant date) {

        if (date == null)
        {
            log.error("La date est incorrect");
            return null;

        }

        Optional<LotDeCarte> lotDeCarte=iLotDeCarteRepositorys.findUserByDate(date);
        return Optional.of(LotDeCarteDto.fromEntity(lotDeCarte.get())).orElseThrow
                ( ()->new EntityNotFoundException(
                        "Aucun utilisateur correspondant à l'ID=" + date,
                        ErrorCodes.LOTDECARTE_NOT_FOUND)
                );
    }*/

    @Override
    public List<LotDeCarteDto> findAll() {
        return iLotDeCarteRepositorys.findAll().stream().map(LotDeCarteDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer idLot) {
        if (idLot == null)
        {
            log.error("L'id du lot  est incorrecte");
            return;

        }

        iLotDeCarteRepositorys.deleteById(idLot);

    }
}
