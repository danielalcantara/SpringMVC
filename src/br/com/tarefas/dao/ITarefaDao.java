package br.com.tarefas.dao;

import java.util.List;

import br.com.tarefas.model.Tarefa;

public interface ITarefaDao {
	public long adiciona(Tarefa tarefa);
	public void editar(Tarefa tarefa);
	public void remover(Tarefa tarefa);
	public Tarefa buscarPorId(Long id);
	public List<Tarefa> lista();
}
