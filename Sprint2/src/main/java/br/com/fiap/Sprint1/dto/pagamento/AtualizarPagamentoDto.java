package br.com.fiap.Sprint1.dto.pagamento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AtualizarPagamentoDto(@NotNull(message = "Número do cartão é obrigatório!")
                                    @Size(min = 16, max = 16, message = "Cartão precisa ter 16 caractéres!")
                                    Long numeroCartao,
                                    @NotNull(message = "Senha do cartão é obrigatório!")
                                    @Size(min = 4, max = 6, message = "Senha do cartão precisa ter de 4 a 6 caractéres!")
                                    int senhaCartao,
                                    @NotEmpty(message = "Data de Validade é obrigatório!")
                                    LocalDate dataValidade,
                                    @NotBlank(message = "Nome não pode estar em branco!")
                                    @Size(min = 15, max = 60, message = "O nome precisa ter no mínimo 15 e no máximo 60 caracteres!")
                                    String nome,
                                    @NotNull(message = "Preço não pode ser nulo")
                                    double preco) {
}
