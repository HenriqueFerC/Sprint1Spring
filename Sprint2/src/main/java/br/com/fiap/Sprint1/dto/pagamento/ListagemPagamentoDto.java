package br.com.fiap.Sprint1.dto.pagamento;

import br.com.fiap.Sprint1.dto.usuario.DetalhesUsuarioDto;
import br.com.fiap.Sprint1.model.Pagamento;

import java.time.LocalDate;

public record ListagemPagamentoDto(Long id, Long numeroCartao, int senhaCartao, LocalDate dataValidade, String nome, double preco, DetalhesUsuarioDto usuarioDto) {
    public ListagemPagamentoDto(Pagamento pagamento){
        this(pagamento.getId(), pagamento.getNumeroCartao(), pagamento.getSenhaCartao(), pagamento.getDataValidade(), pagamento.getNome(), pagamento.getPreco(), new DetalhesUsuarioDto(pagamento.getUsuario()));
    }
}
