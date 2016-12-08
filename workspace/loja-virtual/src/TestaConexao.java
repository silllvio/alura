import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		System.out.println("Olá Silvio");
		Connection connection = new ConnectionPool().getConnection();
		System.out.println("Abrindo conexão");
		connection.close();
	}

}
