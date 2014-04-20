package br.com.tarefas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tarefas.dao.UsuarioDao;
import br.com.tarefas.model.Usuario;

@Controller
public class LoginController {
	@RequestMapping("loginForm")
	public String loginForm() {
		return "formularioLogin";
	}

	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		if (new UsuarioDao().existeUsuario(usuario)) {
			session.setAttribute("usuarioLogado", usuario);
			return "home/menu";
		}
		return "redirect:loginForm";
	}
}
