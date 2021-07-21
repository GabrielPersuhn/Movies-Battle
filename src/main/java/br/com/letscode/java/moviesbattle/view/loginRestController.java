package br.com.letscode.java.moviesbattle.view;

import br.com.letscode.java.moviesbattle.dominio.Usuario;
import br.com.letscode.java.moviesbattle.service.usuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RequestMapping ("/users")
@RestController
@RequiredArgsConstructor
public class loginRestController {

    private final usuarioService usuarioService;

    @GetMapping
    public List<Usuario> listAll() throws IOException {
        return usuarioService.listAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario createNewUser(Usuario newUser) throws IOException {
        return usuarioService.createNewUser(newUser);
    }


}
