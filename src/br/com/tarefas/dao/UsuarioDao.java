package br.com.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.tarefas.jdbc.ConnectionFactory;
import br.com.tarefas.model.Usuario;

public class UsuarioDao {
	// Conexão com bando de dados
	private Connection connection;

	public UsuarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public Usuario buscarPorLogin(String login) {
		// cria um preparedStatement
		String sql = "select * from public.\"Usuario\" where login = ?";
		Usuario usuario = new Usuario();

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, login);

			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
			} else {
				usuario = null;
			}

			rs.close();
			stmt.close();

			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean existeUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		Usuario usuarioBd = this.buscarPorLogin(usuario.getLogin());
		if (usuarioBd != null) {
			return true;
		}
		return false;
	}
	
}
