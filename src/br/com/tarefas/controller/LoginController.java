package br.com.tarefas.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tarefas.dao.UsuarioDao;
import br.com.tarefas.model.Usuario;

@Controller
public class LoginController {
	
	private UsuarioDao usuarioDao;
	
	@Inject
	public LoginController(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@RequestMapping("loginForm")
	public String loginForm() {
		return "formularioLogin";
	}

	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		if (usuarioDao.existeUsuario(usuario)) {
			session.setAttribute("usuarioLogado", usuario);
			return "home/menu";
		}
		return "redirect:loginForm";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "formularioLogin";
	}
}
