package br.com.fiap.Sprint1.dto.chatbot;

import br.com.fiap.Sprint1.model.Chatbot;
import br.com.fiap.Sprint1.model.Duracao;
import br.com.fiap.Sprint1.model.Genero;
import br.com.fiap.Sprint1.model.PerfilDeVisualizacao;

public record DetalhesChatbotDto(Long id,Genero genero, Duracao duracao, PerfilDeVisualizacao publicoAlvo) {
    public DetalhesChatbotDto(Chatbot chatbot){
        this(chatbot.getId(), chatbot.getGenero(), chatbot.getDuracao(), chatbot.getPublicoAlvo());
    }
}
