package br.com.fiap.Sprint1.dto.perfil;

import br.com.fiap.Sprint1.model.PerfilDeVisualizacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record AtualizarPerfilDto(@NotBlank(message = "Campo não pode ser vazio!")
                                 @Size(min = 3, max = 15, message = "Campo precisa ter de 3 a 10 caractéres!")
                                 String nome,
                                 @NotBlank(message = "Campo não pode ser vazio")
                                 @Size(min = 4, max = 6, message = "Campo precisa ter de 4 a 6 caractéres!")
                                 String senha,
                                 @NotEmpty(message = "Tipo de perfil é obrigatório!")
                                 PerfilDeVisualizacao tipo) {
}
