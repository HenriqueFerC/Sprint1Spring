package br.com.fiap.Sprint1.dto.chatbot;

import br.com.fiap.Sprint1.model.Chatbot;
import br.com.fiap.Sprint1.model.Duracao;
import br.com.fiap.Sprint1.model.Genero;
import br.com.fiap.Sprint1.model.PerfilDeVisualizacao;

public record ListagemChatbotDto(Long id, Genero genero, Duracao duracao, PerfilDeVisualizacao publicoAlvo) {
    public ListagemChatbotDto(Chatbot chatbot){
        this(chatbot.getId(), chatbot.getGenero(), chatbot.getDuracao(), chatbot.getPublicoAlvo());
    }
}