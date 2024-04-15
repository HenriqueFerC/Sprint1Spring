package br.com.fiap.Sprint1.model;

import br.com.fiap.Sprint1.dto.pagamento.AtualizarPagamentoDto;
import br.com.fiap.Sprint1.dto.pagamento.CadastrarPagamentoDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter @Setter

@Entity
@Table(name="TB_PAGAMENTO")
public class Pagamento {

    @Id
    @GeneratedValue
    @Column(name="ID_PAGAMENTO")
    private Long id;

    @NotNull(message = "O campo não pode ser nulo!")
    @Column(name="NMR_CARTAO", length = 16, nullable = false)
    private Long numeroCartao;

    @NotNull(message = "O campo não pode ser nulo!")
    @Column(name="SENHA_CARTAO", length = 3, nullable = false)
    private int senhaCartao;


    @Column(name="DT_VALIDADE", nullable = false)
    private LocalDate dataValidade;

    @NotEmpty(message = "O campo não pode ser vazio!")
    @Size(min = 15, max = 60, message = "O nome precisa ter no mínimo 15 e no máximo 60 caracteres!")
    @Column(name="NM_TITULAR", length = 60, nullable = false)
    private String nome;

    @NotNull(message = "O campo não pode ser nulo!")
    @Min(value = 1, message = "O preço deve ser maior do que 0")
    @Column(length = 10, nullable = false)
    private double preco;

    public Pagamento(CadastrarPagamentoDto pagamentoDto){
        numeroCartao = pagamentoDto.numeroCartao();
        senhaCartao = pagamentoDto.senhaCartao();
        dataValidade = pagamentoDto.dataValidade();
        nome = pagamentoDto.nome();
        preco = pagamentoDto.preco();
    }

    public void atualizarPagamento(AtualizarPagamentoDto pagamentoDto){
        numeroCartao = pagamentoDto.numeroCartao();
        senhaCartao = pagamentoDto.senhaCartao();
        dataValidade = pagamentoDto.dataValidade();
        nome = pagamentoDto.nome();
        preco = pagamentoDto.preco();
    }

}
