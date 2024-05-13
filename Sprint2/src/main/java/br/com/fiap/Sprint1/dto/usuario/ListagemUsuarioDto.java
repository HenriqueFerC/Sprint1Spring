package br.com.fiap.Sprint1.dto.usuario;

import br.com.fiap.Sprint1.model.Usuario;

public record ListagemUsuarioDto(Long id, String nome, String login, String senha, String cpf, String plano) {
    public ListagemUsuarioDto(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getSenha(), usuario.getCpf(), usuario.getPlano());
    }
}
