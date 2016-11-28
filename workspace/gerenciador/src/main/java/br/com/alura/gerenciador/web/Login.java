package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

//@WebServlet(urlPatterns = "/login")
public class Login implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

		if (usuario == null) {
			return null;
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario);

			req.setAttribute("usuarioLogado", usuario);

			return "/WEB-INF/paginas/login.jsp";

		}

	}

	// @Override
	// protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	// throws ServletException, IOException {
	//
	// String email = req.getParameter("email");
	// String senha = req.getParameter("senha");
	//
	// PrintWriter writer = resp.getWriter();
	//
	// Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
	//
	// if (usuario == null) {
	//
	// writer.println("<html><body>");
	// writer.println(usuario + " não encontrado");
	// writer.println("</body></html>");
	//
	// }else {
	//
	// HttpSession session = req.getSession();
	// session.setAttribute("usuarioLogado", usuario);
	//
	// req.setAttribute("usuarioLogado", usuario);
	//
	// writer.println("<html><body>");
	// writer.println(usuario + " encontrado");
	// writer.println("</body></html>");
	//
	//
	// }
	//
	//
	// }

}
