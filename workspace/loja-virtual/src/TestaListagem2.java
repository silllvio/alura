import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem2 {

	public static void main(String[] args) throws SQLException {

		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/loja-virtual", "SA", "");

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
