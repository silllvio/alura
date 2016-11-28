package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Usuario;

//Cadeia de Filter ou intercepter
@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String requestURI = req.getRequestURI();

		String usuario = getUsuario(req);

		System.out.println(usuario + " acessando a URI: " + requestURI);
		// Continuar com o request e reponse
		chain.doFilter(request, response);
		
		
		Cookie cookie  = new Cookies(req.getCookies()).buscaUsuarioLogado();
		if (cookie != null){
			cookie.setMaxAge(10 * 60);
			resp.addCookie(cookie);
		}
		
	}

	private String getUsuario(HttpServletRequest req) {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		if (usuario == null) return "<delogado>" ;
		return usuario.getEmail();					
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
