package br.com.nomadweb.osworksapi.domain.exceptions;

public class EntityNotFoundException extends BusinessException{
    public EntityNotFoundException(String message) {
        super(message);
    }
}
