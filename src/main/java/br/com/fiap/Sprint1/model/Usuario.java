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
    @Column(name="ID_USUARIO")
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

    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="ID_PAGAMENTO")
    private Pagamento pagamento;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Perfil> perfil;

    public Usuario(CadastrarUsuarioDto usuarioDto){
        nome = usuarioDto.nome();
        login = usuarioDto.login();
        senha = usuarioDto.senha();
        cpf = usuarioDto.senha();
        plano = usuarioDto.plano();
        pagamento = usuarioDto.pagamento();
    }

    public void atualizarUsuario(AtualizarUsuarioDto usuarioDto){
        nome = usuarioDto.nome();
        login = usuarioDto.login();
        senha = usuarioDto.senha();
        plano = usuarioDto.plano();
    }

}
