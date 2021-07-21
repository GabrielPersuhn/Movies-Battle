package br.com.letscode.java.moviesbattle.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InvalidUserName extends RuntimeException{
    public InvalidUserName(String message) {
        super(message);
    }
}
