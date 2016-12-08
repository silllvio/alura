import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoriaDAO;
import modelo.Categoria;

public class TestaCategorias {

	public static void main(String[] args) throws SQLException {
		
		try(Connection con = new ConnectionPool().getConnection()){
			
			List <Categoria> categorias = new CategoriaDAO(con).lista();
			for (Categoria categoria : categorias) {
				
				System.out.println(categoria);
				
//				for(Produto produto : new ProdutosDAO(con).busca(categoria)){
//					System.out.println(categoria.getNome() + " - " + produto.getNome());
				}
				
			}
			
			
			
		}
		
	}
	
