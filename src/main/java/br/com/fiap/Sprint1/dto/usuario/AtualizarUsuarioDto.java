package br.com.fiap.Sprint1.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record AtualizarUsuarioDto(@NotEmpty(message = "Campo não pode ser vazio!")
                                  @Size(min = 8, max = 60, message = "Campo precisa de no mínimo 8 e no máximo 60 caracteres!")
                                  String nome,
                                  @Email(message = "Campo precisa ser um email!")
                                  @Size(min = 14, max = 60, message = "Campo precisa de no mínimo 14 e no máximo 60 caracteres!")
                                  String login,
                                  @NotEmpty(message = "Campo não pode ser vazio!")
                                  @Size(min = 6, max = 15, message = "Campo precisa de no mínimo 6 e no máximo 15 caracteres!")
                                  String senha,
                                  @NotEmpty(message = "Campo não pode ser vazio!")
                                  @Size(min = 4, max = 10, message = "Campo precisa de no mínimo 4 e no maximo 10 caracteres!")
                                  String plano) {
}
