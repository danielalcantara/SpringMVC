package br.com.tarefas.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.tarefas.dao.ITarefaDao;
import br.com.tarefas.model.Tarefa;

@Transactional
@Controller
@RequestMapping("tarefa")
public class TarefaController {
	
	@Autowired
	@Qualifier("jpaTarefaDao")
	private ITarefaDao tarefaDao;

	@RequestMapping("formAdicionar")
	public String formAdicionar() {
		return "tarefa/adicionar";
	}
	
	@RequestMapping("adicionar")
	public String adicionar(@Valid Tarefa tarefa, BindingResult result) {
		if (result.hasErrors()) {
			return "tarefa/adicionar";
		}
		tarefaDao.adiciona(tarefa);
		return "redirect:listar";
	}
	
	@RequestMapping("listar")
	public String listar(Model model) {
		List<Tarefa> tarefas = tarefaDao.lista();
		model.addAttribute("tarefas", tarefas);
		return "tarefa/listar";
	}
	
	@RequestMapping("remover")
	public String remover(Tarefa tarefa) {
		tarefaDao.remover(tarefa);
		return "redirect:listar";
	}
	
	@RequestMapping("editar")
	public String etidar(@Valid Tarefa tarefa, BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "tarefa/editar";
		} else if ((tarefa.isFinalizado() && tarefa.getDataFinalizacao() == null) || (!tarefa.isFinalizado() && tarefa.getDataFinalizacao() != null)) {
			request.setAttribute("camposObr", true);
			return "tarefa/editar";
		}
		tarefaDao.editar(tarefa);
		return "redirect:listar";
	}
	
	@RequestMapping("formEditar")
	public String formEtidar(Long id, Model model) {
		Tarefa tarefa = tarefaDao.buscarPorId(id);
		model.addAttribute("tarefa", tarefa);
		return "tarefa/editar";
	}
	
	@RequestMapping(value="setSituacao")
	public @ResponseBody Tarefa setStiuacao(Long id, boolean situacao) {
		Tarefa tarefa = tarefaDao.buscarPorId(id);
		
		if (situacao) {
			tarefa.setFinalizado(true);
			Calendar dataFinalizacao = Calendar.getInstance();
			dataFinalizacao.setTime(new Date());
			tarefa.setDataFinalizacao(dataFinalizacao);
		} else {
			tarefa.setFinalizado(false);
			tarefa.setDataFinalizacao(null);
		}
		
		tarefaDao.editar(tarefa);
		
		return tarefa;
	}
}
