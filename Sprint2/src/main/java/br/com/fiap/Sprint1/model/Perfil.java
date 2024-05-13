package br.com.fiap.Sprint1.model;

import br.com.fiap.Sprint1.dto.perfil.AtualizarPerfilDto;
import br.com.fiap.Sprint1.dto.perfil.CadastrarPerfilDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter

@Entity
@Table(name="TB_PERFIL")
public class Perfil {

    @Id
    @GeneratedValue
    @Column(name="ID_PERFIL", nullable = false)
    private Long id;


    @Column(name="NOME_PERFIL", length = 15, nullable = false)
    private String nome;

    @Column(length = 6)
    private String senha;

    @Column(name="PERFIL_DE_VISUALIZACAO", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private PerfilDeVisualizacao tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_USUARIO", nullable = false)
    private Usuario usuario;

    @OneToOne(mappedBy = "perfil", cascade = CascadeType.ALL)
    private Chatbot chatbot;

    public Perfil(CadastrarPerfilDto perfilDto) {
        nome = perfilDto.nome();
        senha = perfilDto.senha();
        tipo = perfilDto.tipo();
    }

    public Perfil(CadastrarPerfilDto perfilDto, Usuario usuario) {
        nome = perfilDto.nome();
        senha = perfilDto.senha();
        tipo = perfilDto.tipo();
        this.usuario = usuario;
    }

    public void atualizarPerfil(AtualizarPerfilDto perfilDto){
        nome = perfilDto.nome();
        senha = perfilDto.senha();
        tipo = perfilDto.tipo();
    }
}
