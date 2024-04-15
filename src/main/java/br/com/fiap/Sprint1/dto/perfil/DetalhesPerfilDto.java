package br.com.fiap.Sprint1.dto.perfil;

import br.com.fiap.Sprint1.model.Perfil;
import br.com.fiap.Sprint1.model.PerfilDeVisualizacao;

public record DetalhesPerfilDto(String nome, String senha, PerfilDeVisualizacao perfil) {
    public DetalhesPerfilDto(Perfil perfil){
        this(perfil.getNome(), perfil.getSenha(), perfil.getTipo());
    }
}
