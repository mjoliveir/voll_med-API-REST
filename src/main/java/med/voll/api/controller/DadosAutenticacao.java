package med.voll.api.controller;

import med.voll.api.usuarios.Usuario;

public record DadosAutenticacao(String login, String senha) {

    public DadosAutenticacao(Usuario usuario){
        this(usuario.getLogin(), usuario.getSenha());
    }
}
