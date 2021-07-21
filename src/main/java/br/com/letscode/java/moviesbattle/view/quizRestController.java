package br.com.letscode.java.moviesbattle.view;


import br.com.letscode.java.moviesbattle.dominio.Response;
import br.com.letscode.java.moviesbattle.service.quizServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/*
Iniciar arquivo "filmes.csv" com os filmes disponíveis para jogar. Você escolhe como fazer.
Iniciar arquivo "jogadores.csv" com os jogadores aptos a jogar. Você escolhe como fazer.

Em cada jogada, será feita uma requisição GET para "/quizz". A resposta contém dois filmes.

A resposta do jogador será enviada como requisição POST para "/quizz"

informando usuário, senha e id do filme/série vencedor.
Tudo deve estar encapsulado no "request body".

O endpoint responde verdadeiro/falso para o resultado e atualiza o progresso em "jogos.csv".
Quando o jogador perde, o progresso final é escrito em "ranking.csv",
tendo o cuidado de manter ordenado. O ranking pode ser acessado em "/ranking"

*/

@RequestMapping("/quizz")
@RestController
@RequiredArgsConstructor
public class quizRestController {

    private final quizServiceImpl quizServiceImpl;

    @GetMapping
    public String listTwoMovies() {
        return quizServiceImpl.createNewQuiz();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response responsePlayer(@RequestBody Response response) {
        return quizServiceImpl.resultAndUpdate(response);
    }

}

