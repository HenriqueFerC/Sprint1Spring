package br.com.fiap.Sprint1.controller;

import br.com.fiap.Sprint1.dto.perfil.AtualizarPerfilDto;
import br.com.fiap.Sprint1.dto.perfil.CadastrarPerfilDto;
import br.com.fiap.Sprint1.dto.perfil.DetalhesPerfilDto;
import br.com.fiap.Sprint1.dto.perfil.ListagemPerfilDto;
import br.com.fiap.Sprint1.model.Perfil;
import br.com.fiap.Sprint1.resository.PerfilRepository;
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

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesPerfilDto> cadastrar(@RequestBody @Valid CadastrarPerfilDto perfilDto, UriComponentsBuilder uriBuilder){
        var perfil = new Perfil(perfilDto);
        perfilRepository.save(perfil);
        var url = uriBuilder.path("perfis/{id}").buildAndExpand(perfil.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesPerfilDto(perfil));
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

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        try {
            perfilRepository.deleteById(id);
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
