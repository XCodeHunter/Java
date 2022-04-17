package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection criarConexao() throws SQLException {
		return DriverManager.
				getConnection("jdbc:mysql://localhost:3306/loja?useTimezone=true&serverTimezone=UTC", "root", "root");
	}
}
