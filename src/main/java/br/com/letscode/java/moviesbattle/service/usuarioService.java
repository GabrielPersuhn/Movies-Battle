package br.com.letscode.java.moviesbattle.service;

import br.com.letscode.java.moviesbattle.dominio.Jogador;
import br.com.letscode.java.moviesbattle.dominio.Usuario;
import br.com.letscode.java.moviesbattle.dominio.Jogador;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public interface usuarioService {
    List<Usuario> listAll() throws IOException;
    boolean loginAttempt(Usuario usuario, String senhaAttempt);
    int isThereSuchUser(String nome) throws IOException;
    Usuario createNewUser(Usuario newUser) throws IOException;
    Jogador logedUser(Optional<Usuario> usuarios, String senhaAttempt) throws IOException;
}
