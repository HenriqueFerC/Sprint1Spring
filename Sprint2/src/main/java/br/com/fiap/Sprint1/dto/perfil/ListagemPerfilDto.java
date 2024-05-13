package br.com.fiap.Sprint1.dto.perfil;

import br.com.fiap.Sprint1.dto.usuario.DetalhesUsuarioDto;
import br.com.fiap.Sprint1.dto.usuario.ListagemUsuarioDto;
import br.com.fiap.Sprint1.model.Perfil;
import br.com.fiap.Sprint1.model.PerfilDeVisualizacao;

public record ListagemPerfilDto(String nome, String senha, PerfilDeVisualizacao perfil, DetalhesUsuarioDto usuarioDto) {
    public ListagemPerfilDto(Perfil perfil){
        this(perfil.getNome(), perfil.getSenha(), perfil.getTipo(), new DetalhesUsuarioDto(perfil.getUsuario()));
    }
}
