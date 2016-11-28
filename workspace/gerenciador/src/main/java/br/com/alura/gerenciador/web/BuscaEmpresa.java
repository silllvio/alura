package br.com.alura.gerenciador.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

//@WebServlet("/busca")
public class BuscaEmpresa implements Tarefa {

	public BuscaEmpresa() {
		System.out.println("Instanciando uma Servlet do tipo BuscaEmpresa " + this);
	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

//		 String filtro = request.getParameter("filtro");
		 String empresaBuscada = req.getParameter("empresaBuscada");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(empresaBuscada);

		req.setAttribute("empresas", empresas);

		return "/WEB-INF/paginas/buscaEmpresa.jsp";

	}

	// @Override
	// protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	// throws ServletException, IOException {
	//
	//
	//// Dormir pelo tempo determinado
	//// try {
	//// Thread.sleep(10000);
	//// } catch (InterruptedException e) {
	//// e.printStackTrace();
	//// }
	//
	// String empresaBuscada = req.getParameter("empresaBuscada");
	//
	// Collection<Empresa> empresas = new
	// EmpresaDAO().buscaPorSimilaridade(empresaBuscada);
	//
	// req.setAttribute("empresas", empresas);
	//
	// RequestDispatcher dispatcher = req
	// .getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp");
	// dispatcher.forward(req, resp);
	//
	// }
}
