package br.com.tarefas.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.IUsuarioDao;
import br.com.tarefas.model.Usuario;

@Repository
public class UsuarioDao implements IUsuarioDao {
	// Conexão com bando de dados
	private Connection connection;

	@Inject
	public UsuarioDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
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
			if (usuario.getSenha().equals(usuarioBd.getSenha())) {
				return true;
			}
		}
		return false;
	}
	
}
