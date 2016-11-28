package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

//@WebServlet(urlPatterns = "/logout")
public class Logout implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		session.removeAttribute("usuarioLogado");
		return "/WEB-INF/paginas/logout.jsp";

	}

	// protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	// throws ServletException, IOException {

	// Apenas remove o atributo.
	// Usuario usuarioLogado = (Usuario) req.getAttribute("usuarioLogado");

	// HttpSession session = req.getSession();
	// Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
	// session.removeAttribute("usuarioLogado");

	// Invalida a cessão, retira tudo.
	// req.getSession().invalidate();

	// PrintWriter writer = resp.getWriter();

	// Redireciona o cliente no cliente.
	// resp.sendRedirect("Logout.html");

	// Redireciona no servidor

	// req.setAttribute("usuario", usuario);
	// RequestDispatcher dispatcher =
	// req.getRequestDispatcher("WEB-INF/paginas/logout.jsp");
	// dispatcher.forward(req, resp);

	// }

}
