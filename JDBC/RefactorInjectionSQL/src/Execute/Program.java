package Execute;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.json.JSONObject;

import Connection.ConnectionFactory;
import DAO.ProdutoDao;
import Model.ProdutoModel;

public class Program {
	
	public static void main(String[] args) throws SQLException {
		ProdutoModel model = new ProdutoModel();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o nome do seu produto: ");
		String nomeProduto = sc.nextLine();
		
		System.out.println("Digite uma descrição para seu produto: ");
		String descricaoProduto = sc.nextLine();
		
		model.setNome(nomeProduto);
		model.setDescricao(descricaoProduto);
		
		try(Connection connection = new ConnectionFactory().criarConexao()){
			ProdutoDao dao = new ProdutoDao(connection);
			dao.Salvar(model);
			
			List<ProdutoModel> prodList = dao.listarProduto();
			
			prodList.stream().forEach(pl -> {
				
				JSONObject json = new JSONObject();
				json.put("idProduto", pl.getId());
				json.put("NomeProduto", pl.getNome());
				json.put("descricaoProduto", pl.getDescricao());
				System.out.println(json);
			});
		}
	}

}
