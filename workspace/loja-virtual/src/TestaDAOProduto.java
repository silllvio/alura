import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.ProdutosDAO;
import modelo.Produto;

public class TestaDAOProduto {

	public static void main(String[] args) throws SQLException {

		Produto mesa = new Produto("Mesa vermelha", "Mesa de 4 pés");

		try (Connection con = new ConnectionPool().getConnection()) {

			ProdutosDAO dao = new ProdutosDAO(con);
			dao.salva(mesa);
			List <Produto> produtos = dao.lista();
			for (Produto produto : produtos) {
				System.out.println(produto);
				
			}

		}
//		System.out.println(mesa);
	}

}
