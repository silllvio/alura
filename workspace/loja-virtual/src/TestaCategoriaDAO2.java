import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoriaDAO2;
import modelo.Categoria2;
import modelo.Produto;

public class TestaCategoriaDAO2 {

	public static void main(String[] args) throws SQLException {
//
//		try (Connection con = new ConnectionPool().getConnection()) {
//			List<Categoria2> categorias = new CategoriaDAO2(con).getLista();
//			for (Categoria2 categoria2 : categorias) {
//			System.out.println(categoria2);
//
//				for(Produto produto : new ProdutosDAO(con).busca(categoria2)){
//					System.out.println(produto.getNome() + " - " + categoria2.getNome());
//				}
//			
//			}
//
//			
//			
//		}
//

		try (Connection con = new ConnectionPool().getConnection()) {
			List<Categoria2> categorias = new CategoriaDAO2(con).getListaComCat();
			for (Categoria2 categoria2 : categorias) {
			System.out.println(categoria2.getNome());

				for(Produto produto : categoria2.getProdutos()){
					System.out.println(produto.getNome() + " - " + categoria2.getNome());
				}
			
			}

			
			
		}
	
	}

}
