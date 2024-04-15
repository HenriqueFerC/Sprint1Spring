package br.com.fiap.Sprint1.controller;

import br.com.fiap.Sprint1.dto.usuario.AtualizarUsuarioDto;
import br.com.fiap.Sprint1.dto.usuario.CadastrarUsuarioDto;
import br.com.fiap.Sprint1.dto.usuario.DetalhesUsuarioDto;
import br.com.fiap.Sprint1.dto.usuario.ListagemUsuarioDto;
import br.com.fiap.Sprint1.model.Usuario;
import br.com.fiap.Sprint1.resository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesUsuarioDto> cadastrar(@RequestBody @Valid CadastrarUsuarioDto usuarioDto, UriComponentsBuilder uriBuilder){
        var usuario = new Usuario(usuarioDto);
        usuarioRepository.save(usuario);
        var url = uriBuilder.path("usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesUsuarioDto(usuario));
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesUsuarioDto> buscarPorId(@PathVariable("id") Long id){
        try {
            var usuario = usuarioRepository.getReferenceById(id);
            return ResponseEntity.ok(new DetalhesUsuarioDto(usuario));
        } catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ListagemUsuarioDto>> listar(Pageable pageable){
        var lista = usuarioRepository.findAll(pageable).stream().map(ListagemUsuarioDto::new).toList();
        if(lista.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesUsuarioDto> atualizar(@PathVariable("id") Long id, @RequestBody @Valid AtualizarUsuarioDto usuarioDto){
        var usuario = usuarioRepository.getReferenceById(id);
        usuario.atualizarUsuario(usuarioDto);
        return ResponseEntity.ok(new DetalhesUsuarioDto(usuario));
    }

    @DeleteMapping({"{id}"})
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        try {
            usuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
