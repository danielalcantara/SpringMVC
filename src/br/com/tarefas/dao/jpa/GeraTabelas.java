package br.com.tarefas.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.tarefas.model.Usuario;

public class GeraTabelas {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("springmvc");
		EntityManager manager = factory.createEntityManager();
		Usuario usuario = new Usuario();
		usuario.setNome("Daniel Alcântara");
		usuario.setLogin("daniel");
		usuario.setSenha("teste");
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		System.out.println("Usuario com id " + usuario.getId() + " adicionado com sucesso!");
		factory.close();
	}

}
