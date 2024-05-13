package br.com.fiap.Sprint1.model;

import br.com.fiap.Sprint1.dto.usuario.AtualizarUsuarioDto;
import br.com.fiap.Sprint1.dto.usuario.CadastrarUsuarioDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter @Setter

@Entity
@Table(name="TB_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue
    @Column(name="ID_USUARIO", nullable = false)
    private Long id;

    @Column(length = 60, nullable = false)
    private String nome;

    @Column(length = 80, nullable = false)
    private String login;


    @Column(length = 15, nullable = false)
    private String senha;

    @Column(length = 14, nullable = false)
    private String cpf;

    @Column(length = 10, nullable = false)
    private String plano;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Perfil> perfis;

    public void adicionarPerfil(Perfil perfil){
        perfis.add(perfil);
    }

    public void removerPerfil(Perfil perfil){
        perfis.remove(perfil);
    }

    public Usuario(CadastrarUsuarioDto usuarioDto){
        nome = usuarioDto.nome();
        login = usuarioDto.login();
        senha = usuarioDto.senha();
        cpf = usuarioDto.senha();
        plano = usuarioDto.plano();
    }

    public void atualizarUsuario(AtualizarUsuarioDto usuarioDto){
        nome = usuarioDto.nome();
        login = usuarioDto.login();
        senha = usuarioDto.senha();
        plano = usuarioDto.plano();
    }


}
