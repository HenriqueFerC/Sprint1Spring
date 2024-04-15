package br.com.fiap.Sprint1.dto.pagamento;

import java.time.LocalDate;

public record CadastrarPagamentoDto(Long numeroCartao, int senhaCartao, LocalDate dataValidade, String nome, double preco) {
}
