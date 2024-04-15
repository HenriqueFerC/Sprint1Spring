package br.com.fiap.Sprint1.dto.pagamento;

import java.time.LocalDate;

public record AtualizarPagamentoDto(Long numeroCartao, int senhaCartao, LocalDate dataValidade, String nome, double preco) {
}
