package br.com.fiap.Sprint1.controller;

import br.com.fiap.Sprint1.dto.chatbot.AtualizarChatbotDto;
import br.com.fiap.Sprint1.dto.chatbot.CadastrarChatbotDto;
import br.com.fiap.Sprint1.dto.chatbot.DetalhesChatbotDto;
import br.com.fiap.Sprint1.dto.chatbot.ListagemChatbotDto;
import br.com.fiap.Sprint1.model.Chatbot;
import br.com.fiap.Sprint1.resository.ChatbotRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("chatbots")
public class ChatbotController {

    @Autowired
    private ChatbotRepository chatbotRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesChatbotDto> cadastrar(@RequestBody @Valid CadastrarChatbotDto chatbotDto, UriComponentsBuilder uriBuilder){
        var chatbot = new Chatbot(chatbotDto);
        chatbotRepository.save(chatbot);
        var url = uriBuilder.path("chatbots/{id}").buildAndExpand(chatbot.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesChatbotDto(chatbot));
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesChatbotDto> buscarPorId(@PathVariable("id") Long id){
        try {
            var chatbot = chatbotRepository.getReferenceById(id);
            return ResponseEntity.ok(new DetalhesChatbotDto(chatbot));
        } catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ListagemChatbotDto>> listar(Pageable pageable){
        var lista = chatbotRepository.findAll(pageable).stream().map(ListagemChatbotDto::new).toList();
        if(lista.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        try {
            chatbotRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesChatbotDto> atualizar(@PathVariable("id") Long id, @RequestBody @Valid AtualizarChatbotDto chatbotDto){
        var chatbot = chatbotRepository.getReferenceById(id);
        chatbot.atualizarChatbot(chatbotDto);
        return ResponseEntity.ok(new DetalhesChatbotDto(chatbot));
    }

    @GetMapping("filme")
    public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastrarChatbotDto chatbotDto){
        var chatbot = new Chatbot(chatbotDto);
        var resultado = chatbot.consultarFilme(chatbotDto);
        return ResponseEntity.ok(resultado);
    }

}
