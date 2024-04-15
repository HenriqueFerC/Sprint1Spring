package br.com.fiap.Sprint1.dto.chatbot;

import br.com.fiap.Sprint1.model.Duracao;
import br.com.fiap.Sprint1.model.Genero;
import br.com.fiap.Sprint1.model.PerfilDeVisualizacao;
import jakarta.validation.constraints.NotEmpty;

public record CadastrarChatbotDto(//@NotEmpty(message = "Campo não pode ser vazio!")
                                  Genero genero,
                                  //@NotEmpty(message = "Campo não pode ser vazio!")
                                  Duracao duracao,
                                  //@NotEmpty(message = "Campo não pode ser vazio!")
                                  PerfilDeVisualizacao publicoAlvo) {
}
