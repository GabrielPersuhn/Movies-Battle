package br.com.letscode.java.moviesbattle.DAO;

import br.com.letscode.java.moviesbattle.dominio.Usuario;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface usuarioDAO {
    Optional<Usuario> findByUserName(String userName) throws IOException;
    List<Usuario> getAll() throws IOException;
    Usuario csvLineToUser( String linha);
    String userToCsVLine (Usuario writtenUser);



    }
