package br.com.tarefas.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.IUsuarioDao;
import br.com.tarefas.model.Usuario;

@Repository
public class JpaUsuarioDao implements IUsuarioDao {

	@PersistenceContext
	EntityManager manager;

	@Override
	public Usuario buscarPorLogin(String login) {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("select u from Usuario as u "
				+ "where u.login = :login");
		try {
			query.setParameter("login", login);
			return (Usuario) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
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
