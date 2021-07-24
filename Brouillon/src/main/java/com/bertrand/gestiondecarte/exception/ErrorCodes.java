package com.bertrand.gestiondecarte.exception;

import org.springframework.validation.Errors;

public enum ErrorCodes {
    AGENCE_NOT_FOUND(1000),
    ALERTE_NOT_FOUND(2000),
    CARTE_NOT_FOUND(3000),
    CLIENT_NOT_FOUND(4000),
    COMPTE_NOT_FOUND(5000),
    LOTDECARTE_NOT_FOUND(6000),
    UTILISATEUR_NOT_FOUND(7000);

    private int code;

    ErrorCodes(int code){
        this.code=code;
    }

    public int getCode(){
        return code;
    }
}
