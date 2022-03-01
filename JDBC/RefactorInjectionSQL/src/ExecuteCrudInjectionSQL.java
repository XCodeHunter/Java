import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExecuteCrudInjectionSQL {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o nome do produto: ");
		String nomeProduto = sc.nextLine();

		System.out.println("Digite uma descrição para o produto: ");
		String descricaoProduto = sc.nextLine();

		ConnectionFactory fac = new ConnectionFactory();
		try (Connection con = fac.criarConexao()) {

			// Para termos controle de transação necessario desabilitar o auto commit do
			// JDBC
			con.setAutoCommit(false);

			try (PreparedStatement prepared = con
					.prepareStatement("INSERT INTO PRODUTO (nome,descricao) VALUES (?,?)");) {
				adicionaProduto(nomeProduto, descricaoProduto, prepared);
				con.commit();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				con.rollback();
			}
		};
	}

	private static void adicionaProduto(String nomeProduto, String descricaoProduto, PreparedStatement prepared)
			throws SQLException {
		prepared.setString(1, nomeProduto);
		prepared.setString(2, descricaoProduto);

		prepared.execute();
	}

}
