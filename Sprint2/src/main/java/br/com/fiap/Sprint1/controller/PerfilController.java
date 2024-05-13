package br.com.fiap.Sprint1.controller;

import br.com.fiap.Sprint1.dto.chatbot.CadastrarChatbotDto;
import br.com.fiap.Sprint1.dto.chatbot.DetalhesChatbotDto;
import br.com.fiap.Sprint1.dto.perfil.AtualizarPerfilDto;
import br.com.fiap.Sprint1.dto.perfil.CadastrarPerfilDto;
import br.com.fiap.Sprint1.dto.perfil.DetalhesPerfilDto;
import br.com.fiap.Sprint1.dto.perfil.ListagemPerfilDto;
import br.com.fiap.Sprint1.model.Chatbot;
import br.com.fiap.Sprint1.model.Perfil;
import br.com.fiap.Sprint1.resository.ChatbotRepository;
import br.com.fiap.Sprint1.resository.PerfilRepository;
import br.com.fiap.Sprint1.resository.UsuarioRepository;
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
@RequestMapping("perfis")
public class PerfilController {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ChatbotRepository chatbotRepository;

    @PostMapping("{id}/chatbot")
    @Transactional
    public ResponseEntity<DetalhesChatbotDto> cadastrarChatbot(@PathVariable("id") Long id, @RequestBody @Valid CadastrarChatbotDto cadastroChatbot, UriComponentsBuilder uriBuilder){
        var perfil = perfilRepository.getReferenceById(id);
        var chatbot = new Chatbot(cadastroChatbot, perfil);
        chatbotRepository.save(chatbot);
        var url = uriBuilder.path("chatbots/{id}").buildAndExpand(chatbot.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesChatbotDto(chatbot));
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesPerfilDto> buscarPorId(@PathVariable("id") Long id){
        try {
            var perfil = perfilRepository.getReferenceById(id);
            return ResponseEntity.ok(new DetalhesPerfilDto(perfil));
        } catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ListagemPerfilDto>> listar(Pageable pageable){
        var lista = perfilRepository.findAll(pageable).stream().map(ListagemPerfilDto::new).toList();
        if(lista.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("{idPerfil}/usuario/{idUsuario}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("idPerfil") Long idPerfil, @PathVariable("idUsuario") Long idUsuario){
        try {
            var usuario = usuarioRepository.getReferenceById(idUsuario);
            var perfil = perfilRepository.getReferenceById(idPerfil);
            usuario.removerPerfil(perfil);
            perfilRepository.deleteById(idPerfil);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesPerfilDto> atualizar(@PathVariable("id") Long id, @RequestBody @Valid AtualizarPerfilDto perfilDto){
        var perfil = perfilRepository.getReferenceById(id);
        perfil.atualizarPerfil(perfilDto);
        return ResponseEntity.ok(new DetalhesPerfilDto(perfil));
    }
}
