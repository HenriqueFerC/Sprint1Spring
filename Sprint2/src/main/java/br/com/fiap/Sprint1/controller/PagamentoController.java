package br.com.fiap.Sprint1.controller;

import br.com.fiap.Sprint1.dto.chatbot.AtualizarChatbotDto;
import br.com.fiap.Sprint1.dto.chatbot.CadastrarChatbotDto;
import br.com.fiap.Sprint1.dto.chatbot.DetalhesChatbotDto;
import br.com.fiap.Sprint1.dto.chatbot.ListagemChatbotDto;
import br.com.fiap.Sprint1.dto.pagamento.AtualizarPagamentoDto;
import br.com.fiap.Sprint1.dto.pagamento.CadastrarPagamentoDto;
import br.com.fiap.Sprint1.dto.pagamento.DetalhesPagamentoDto;
import br.com.fiap.Sprint1.dto.pagamento.ListagemPagamentoDto;
import br.com.fiap.Sprint1.model.Chatbot;
import br.com.fiap.Sprint1.model.Pagamento;
import br.com.fiap.Sprint1.model.Perfil;
import br.com.fiap.Sprint1.resository.ChatbotRepository;
import br.com.fiap.Sprint1.resository.PagamentoRepository;
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
@RequestMapping("pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("{id}")
    public ResponseEntity<DetalhesPagamentoDto> buscarPorId(@PathVariable("id") Long id){
        try {
            var pagamento = pagamentoRepository.getReferenceById(id);
            return ResponseEntity.ok(new DetalhesPagamentoDto(pagamento));
        } catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ListagemPagamentoDto>> listar(Pageable pageable){
        var lista = pagamentoRepository.findAll(pageable).stream().map(ListagemPagamentoDto::new).toList();
        if(lista.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("{idPagamento}/usuario/{idUsuario}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("idPagamento") Long idPagamento, @PathVariable("idUsuario") Long idUsuario){
        try {
            var usuario = usuarioRepository.getReferenceById(idUsuario);
            usuario.setPagamento(null);
            pagamentoRepository.deleteById(idPagamento);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesPagamentoDto> atualizar(@PathVariable("id") Long id, @RequestBody @Valid AtualizarPagamentoDto pagamentoDto){
        var pagamento = pagamentoRepository.getReferenceById(id);
        pagamento.atualizarPagamento(pagamentoDto);
        return ResponseEntity.ok(new DetalhesPagamentoDto(pagamento));
    }
}
