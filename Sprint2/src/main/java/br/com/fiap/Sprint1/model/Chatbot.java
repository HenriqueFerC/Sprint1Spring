package br.com.fiap.Sprint1.model;

import br.com.fiap.Sprint1.dto.chatbot.AtualizarChatbotDto;
import br.com.fiap.Sprint1.dto.chatbot.CadastrarChatbotDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name="TB_CHATBOT")
public class Chatbot {

    @Id
    @Column(name="ID_CHATBOT")
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Duracao duracao;

    @Column(name = "PUBLICO_ALVO", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private PerfilDeVisualizacao publicoAlvo;

    @OneToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Perfil perfil;

    public Chatbot(CadastrarChatbotDto chatbotDto){
        genero = chatbotDto.genero();
        duracao = chatbotDto.duracao();
        publicoAlvo = chatbotDto.publicoAlvo();
    }

    public Chatbot(CadastrarChatbotDto chatbotDto, Perfil perfil){
        genero = chatbotDto.genero();
        duracao = chatbotDto.duracao();
        publicoAlvo = chatbotDto.publicoAlvo();
        this.perfil = perfil;
    }

    public void atualizarChatbot(AtualizarChatbotDto chatbotDto){
        genero = chatbotDto.genero();
        duracao = chatbotDto.duracao();
        publicoAlvo = chatbotDto.publicoAlvo();
    }

    public String consultarFilme(CadastrarChatbotDto chatbotDto) {
        if (chatbotDto.genero() == Genero.AÇÃO) {
            if (chatbotDto.duracao() == Duracao.DUAS_HORAS_MEIA) {
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.INFANTIL) {
                    return "FilmeA";
                }
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.ADULTO) {
                    return "FilmeB";
                }
            }
            if (chatbotDto.duracao() == Duracao.DUAS_HORAS) {
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.INFANTIL) {
                    return "FilmeC";
                }
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.ADULTO) {
                    return "FilmeD";
                }
            }
            if (chatbotDto.duracao() == Duracao.TRES_HORAS) {
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.INFANTIL) {
                    return "FilmeE";
                }
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.ADULTO) {
                    return "FilmeF";
                }
            }
        }
        if (chatbotDto.genero() == Genero.COMÉDIA) {
            if (chatbotDto.duracao() == Duracao.DUAS_HORAS_MEIA) {
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.INFANTIL) {
                    return "FilmeG";
                }
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.ADULTO) {
                    return "FilmeH";
                }
            }
            if (chatbotDto.duracao() == Duracao.DUAS_HORAS) {
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.INFANTIL) {
                    return "FilmeI";
                }
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.ADULTO) {
                    return "FilmeJ";
                }
            }
            if (chatbotDto.duracao() == Duracao.TRES_HORAS) {
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.INFANTIL) {
                    return "FilmeK";
                }
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.ADULTO) {
                    return "FilmeL";
                }
            }
        }
        if (chatbotDto.genero() == Genero.DRAMA) {
            if (chatbotDto.duracao() == Duracao.DUAS_HORAS_MEIA) {
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.INFANTIL) {
                    return "FilmeM";
                }
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.ADULTO) {
                    return "FilmeN";
                }
            }
            if (chatbotDto.duracao() == Duracao.DUAS_HORAS) {
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.INFANTIL) {
                    return "FilmeO";
                }
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.ADULTO) {
                    return "FilmeP";
                }
            }
            if (chatbotDto.duracao() == Duracao.TRES_HORAS) {
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.INFANTIL) {
                    return "FilmeQ";
                }
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.ADULTO) {
                    return "FilmeR";
                }
            }
        }
        if (chatbotDto.genero() == Genero.FICCAO) {
            if (chatbotDto.duracao() == Duracao.DUAS_HORAS_MEIA) {
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.INFANTIL) {
                    return "FilmeS";
                }
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.ADULTO) {
                    return "FilmeT";
                }
            }
            if (chatbotDto.duracao() == Duracao.DUAS_HORAS) {
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.INFANTIL) {
                    return "FilmeU";
                }
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.ADULTO) {
                    return "FilmeV";
                }
            }
            if (chatbotDto.duracao() == Duracao.TRES_HORAS) {
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.INFANTIL) {
                    return "FilmeW";
                }
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.ADULTO) {
                    return "FilmeX";
                }
            }
        }
        if (chatbotDto.genero() == Genero.ROMANCE) {
            if (chatbotDto.duracao() == Duracao.DUAS_HORAS_MEIA) {
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.INFANTIL) {
                    return "FilmeY";
                }
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.ADULTO) {
                    return "FilmeZ";
                }
            }
            if (chatbotDto.duracao() == Duracao.DUAS_HORAS) {
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.INFANTIL) {
                    return "FilmeA1";
                }
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.ADULTO) {
                    return "FilmeB1";
                }
            }
            if (chatbotDto.duracao() == Duracao.TRES_HORAS) {
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.INFANTIL) {
                    return "FilmeC1";
                }
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.ADULTO) {
                    return "FilmeD1";
                }
            }
        }
        if (chatbotDto.genero() == Genero.SUSPENSE) {
            if (chatbotDto.duracao() == Duracao.DUAS_HORAS_MEIA) {
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.INFANTIL) {
                    return "FilmeE1";
                }
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.ADULTO) {
                    return "FilmeF1";
                }
            }
            if (chatbotDto.duracao() == Duracao.DUAS_HORAS) {
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.INFANTIL) {
                    return "FilmeG1";
                }
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.ADULTO) {
                    return "FilmeH1";
                }
            }
            if (chatbotDto.duracao() == Duracao.TRES_HORAS) {
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.INFANTIL) {
                    return "FilmeI1";
                }
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.ADULTO) {
                    return "FilmeJ1";
                }
            }
        }
        if (chatbotDto.genero() == Genero.TERROR) {
            if (chatbotDto.duracao() == Duracao.DUAS_HORAS_MEIA) {
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.INFANTIL) {
                    return "FilmeK1";
                }
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.ADULTO) {
                    return "FilmeL1";
                }
            }
            if (chatbotDto.duracao() == Duracao.DUAS_HORAS) {
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.INFANTIL) {
                    return "FilmeM1";
                }
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.ADULTO) {
                    return "FilmeN1";
                }
            }
            if (chatbotDto.duracao() == Duracao.TRES_HORAS) {
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.INFANTIL) {
                    return "FilmeO1";
                }
                if (chatbotDto.publicoAlvo() == PerfilDeVisualizacao.ADULTO) {
                    return "FilmeP1";
                }
            }
        }
        return null;
    }

}
