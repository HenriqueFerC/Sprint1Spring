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
    @Column(name="ID_PERFIL")
    private Long id;


    @Column(name="NOME_PERFIL", length = 10, nullable = false)
    private String nome;

    private String senha;

    @Enumerated(EnumType.STRING)
    private PerfilDeVisualizacao tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_USUARIO")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name="id_chatbot")
    private Chatbot chatbot;

    public Perfil(CadastrarPerfilDto perfilDto) {
        nome = perfilDto.nome();
        senha = perfilDto.senha();
        tipo = perfilDto.tipo();
        usuario = perfilDto.usuario();
        chatbot = perfilDto.chatbot();
    }

    public void atualizarPerfil(AtualizarPerfilDto perfilDto){
        nome = perfilDto.nome();
        senha = perfilDto.senha();
        tipo = perfilDto.tipo();
    }
}
