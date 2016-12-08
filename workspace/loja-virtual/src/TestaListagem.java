import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		ConnectionPool database = new ConnectionPool();
		for (int i = 0; i < 100; i++) {
			
		Connection connection = database.getConnection();
		
		
		Statement statement = connection.createStatement();
		Boolean result = statement.execute("select * from Produto");
		ResultSet resultset = statement.getResultSet();
	
		while (resultset.next()) {
			Integer id = resultset.getInt("id");
			String nome = resultset.getString("nome");
			String descricao = resultset.getString("descricao");
			System.out.println(id);
			System.out.println(nome);
			System.out.println(descricao);
			System.out.println(result);
		}
		resultset.close();
		statement.close();
		connection.close();
		}
	}

	
}
