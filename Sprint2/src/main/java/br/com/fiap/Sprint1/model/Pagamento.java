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
    @Column(name="ID_PAGAMENTO", nullable = false)
    private Long id;

    @Column(name="NMR_CARTAO", length = 16, nullable = false)
    private Long numeroCartao;

    @Column(name="SENHA_CARTAO", length = 3, nullable = false)
    private int senhaCartao;


    @Column(name="DT_VALIDADE", nullable = false)
    private LocalDate dataValidade;

    @Column(name="NM_TITULAR", length = 50, nullable = false)
    private String nome;

    @Column(length = 10, nullable = false)
    private double preco;

    @OneToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;

    public Pagamento(CadastrarPagamentoDto pagamentoDto){
        numeroCartao = pagamentoDto.numeroCartao();
        senhaCartao = pagamentoDto.senhaCartao();
        dataValidade = pagamentoDto.dataValidade();
        nome = pagamentoDto.nome();
        preco = pagamentoDto.preco();
    }

    public Pagamento(CadastrarPagamentoDto pagamentoDto, Usuario usuario){
        numeroCartao = pagamentoDto.numeroCartao();
        senhaCartao = pagamentoDto.senhaCartao();
        dataValidade = pagamentoDto.dataValidade();
        nome = pagamentoDto.nome();
        preco = pagamentoDto.preco();
        this.usuario = usuario;
    }

    public void atualizarPagamento(AtualizarPagamentoDto pagamentoDto){
        numeroCartao = pagamentoDto.numeroCartao();
        senhaCartao = pagamentoDto.senhaCartao();
        dataValidade = pagamentoDto.dataValidade();
        nome = pagamentoDto.nome();
        preco = pagamentoDto.preco();
    }

}
