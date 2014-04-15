package br.com.tarefas.jdbc.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.tarefas.dao.TarefaDao;
import br.com.tarefas.model.Tarefa;

public class TarefaDaoTest {
	
	private TarefaDao tarefaDao;

	@Before
	public void setUp() throws Exception {
		tarefaDao = new TarefaDao();
	}

	@Test
	public void testAdiciona() {
		Tarefa tarefa = new Tarefa();
		tarefa.setTitulo("Tarefa Teste Unitário");
		tarefa.setDescricao("Teste adicionar nova tarefa");
		long id = tarefaDao.adiciona(tarefa);
		System.out.println("Id gerado foi: " + id);
		Assert.assertNotEquals(id, 0);
	}

}
