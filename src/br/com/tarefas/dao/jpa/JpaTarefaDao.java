package br.com.tarefas.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.tarefas.dao.ITarefaDao;
import br.com.tarefas.model.Tarefa;

@Repository
public class JpaTarefaDao implements ITarefaDao {
	
	@PersistenceContext
	EntityManager manager;

	@Override
	public long adiciona(Tarefa tarefa) {
		manager.persist(tarefa);
		return tarefa.getId();
	}

	@Override
	public void editar(Tarefa tarefa) {
		manager.merge(tarefa);
	}

	@Override
	public void remover(Tarefa tarefa) {
		Tarefa tarefaARemover = buscarPorId(tarefa.getId());
		manager.remove(tarefaARemover);
	}

	@Override
	public Tarefa buscarPorId(Long id) {
		return manager.find(Tarefa.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tarefa> lista() {
		return manager.createQuery("select t from Tarefa t order by t.id").getResultList();
	}

}
