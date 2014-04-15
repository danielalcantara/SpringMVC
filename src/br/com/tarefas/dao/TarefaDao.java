package br.com.tarefas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.tarefas.jdbc.ConnectionFactory;
import br.com.tarefas.model.Tarefa;

public class TarefaDao {
	// Conexão com bando de dados
	private Connection connection;

	public TarefaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public long adiciona(Tarefa tarefa) {
		// cria um preparedStatement
		long id = 0;
		String sql = "INSERT INTO public.\"Tarefa\""
				+ " (titulo, descricao, finalizado, \"dataFinalizacao\")" + " values (?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, tarefa.getTitulo());
			stmt.setString(2, tarefa.getDescricao());
			stmt.setBoolean(3, tarefa.isFinalizado());
			
			if (tarefa.getDataFinalizacao() != null) {
				stmt.setDate(4, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			} else {
				stmt.setNull(4, java.sql.Types.NULL);
			}

			// executa
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			
			if (rs != null && rs.next()) {
				id = rs.getLong(1);
			}
			
			stmt.close();
			System.out.println("Gravado!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return id;
	}

	public void editar(Tarefa tarefa) {
		// cria um preparedStatement
		String sql = "update public.\"Tarefa\" set titulo = ?, descricao = ?, finalizado = ?, \"dataFinalizacao\" = ? where id = ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, tarefa.getTitulo());
			stmt.setString(2, tarefa.getDescricao());
			stmt.setBoolean(3, tarefa.isFinalizado());
			
			if (tarefa.getDataFinalizacao() != null) {
				stmt.setDate(4, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			} else {
				stmt.setNull(4, java.sql.Types.NULL);
			}
			
			stmt.setLong(5, tarefa.getId());

			// executa
			stmt.execute();
			stmt.close();
			System.out.println("Editado!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remover(Tarefa tarefa) {
		// cria um preparedStatement
		String sql = "delete from public.\"Tarefa\" where id = ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, tarefa.getId());

			// executa
			stmt.execute();
			stmt.close();
			System.out.println("Excluido!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Tarefa buscar(Tarefa tarefa) {
		// cria um preparedStatement
		String sql = "select * from public.\"Tarefa\" where id = ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, tarefa.getId());

			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			tarefa.setId(rs.getLong("id"));
			tarefa.setTitulo(rs.getString("titulo"));
			tarefa.setDescricao(rs.getString("descricao"));
			tarefa.setFinalizado(rs.getBoolean("finalizado"));

			if (rs.getDate("dataFinalizacao") != null) {
				// Montando data através do calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataFinalizacao"));
				tarefa.setDataFinalizacao(data);
			}

			rs.close();
			stmt.close();

			return tarefa;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Tarefa buscarPorId(Long id) {
		// cria um preparedStatement
		String sql = "select * from public.\"Tarefa\" where id = ?";
		Tarefa tarefa = new Tarefa();

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			tarefa.setId(rs.getLong("id"));
			tarefa.setTitulo(rs.getString("titulo"));
			tarefa.setDescricao(rs.getString("descricao"));
			tarefa.setFinalizado(rs.getBoolean("finalizado"));
			
			if (rs.getDate("dataFinalizacao") != null) {
				// Montando data através do calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataFinalizacao"));
				tarefa.setDataFinalizacao(data);
			}

			rs.close();
			stmt.close();

			return tarefa;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Tarefa> lista() {
		// cria um preparedStatement
		String sql = "select * from public.\"Tarefa\" order by id";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			List<Tarefa> tarefas = new ArrayList<Tarefa>();

			while (rs.next()) {
				Tarefa tarefa = new Tarefa();

				tarefa.setId(rs.getLong("id"));
				tarefa.setTitulo(rs.getString("titulo"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));
				
				if (rs.getDate("dataFinalizacao") != null) {
					// Montando data através do calendar
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("dataFinalizacao"));
					tarefa.setDataFinalizacao(data);
				}
				
				// Adicionando tarefa
				tarefas.add(tarefa);
			}

			rs.close();
			stmt.close();

			return tarefas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
