package br.com.fiap.Sprint1.dto.perfil;

import br.com.fiap.Sprint1.model.Chatbot;
import br.com.fiap.Sprint1.model.PerfilDeVisualizacao;
import br.com.fiap.Sprint1.model.Usuario;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record CadastrarPerfilDto(@NotEmpty
                                 @Size(min = 3, max = 10)
                                 String nome,
                                 String senha,
                                 //@NotEmpty
                                 PerfilDeVisualizacao tipo,
                                 Usuario usuario,
                                 Chatbot chatbot) {
}
