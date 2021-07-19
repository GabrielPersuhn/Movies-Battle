package br.com.letscode.java.moviesbattle.service;

import br.com.letscode.java.moviesbattle.dominio.Usuario;

import java.io.IOException;
import java.util.List;

public interface usuarioService {
    List<Usuario> listAll() throws IOException;

    int isThereSuchUser(String nome); // retorna 0 se não houver - é uma maneira de juntar um método de retorno booleano com int

}
