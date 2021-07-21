package br.com.letscode.java.moviesbattle.view;

import br.com.letscode.java.moviesbattle.DAO.jogadorDAO;
import br.com.letscode.java.moviesbattle.dominio.Jogador;
import br.com.letscode.java.moviesbattle.dominio.Usuario;
import br.com.letscode.java.moviesbattle.service.rankingService;
import br.com.letscode.java.moviesbattle.service.usuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping ("/ranking")
@RestController
public class rankingRestController {

    private rankingService rankingService;

    @GetMapping
    public List<Jogador> showRanking(){

    }
}
