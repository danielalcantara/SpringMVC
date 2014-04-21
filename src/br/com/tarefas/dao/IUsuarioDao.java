package br.com.tarefas.dao;

import br.com.tarefas.model.Usuario;

public interface IUsuarioDao {
	public Usuario buscarPorLogin(String login);
	public boolean existeUsuario(Usuario usuario);
}
