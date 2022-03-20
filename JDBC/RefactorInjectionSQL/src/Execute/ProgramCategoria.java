package Execute;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import DAO.CategoriaDAO;
import Model.CategoriaModel;
import NewProgram.ConnectionFactory;

public class ProgramCategoria {
	public static void main(String[] args) throws SQLException {
		JSONObject json = new JSONObject();
		List<JSONObject> jsonList = new ArrayList<>();
		
		try(Connection connection = new ConnectionFactory().criarConexao()){
			CategoriaDAO dao = new CategoriaDAO(connection);
			List<CategoriaModel> listCategoria = dao.listarCategoria();
			listCategoria.stream().forEach(lc -> {
				
				json.put("IdCategoria", lc.getId());
				json.put("NomeCategoria", lc.getNome());
				
				lc.getProdutos().stream().forEach((produto) -> {
					JSONObject jsonProduto = new JSONObject();
					jsonProduto.put("IdProduto", produto.getId());
					jsonProduto.put("NomeProduto", produto.getNome());
					jsonProduto.put("Descricao", produto.getDescricao());
					
					jsonList.add(jsonProduto);
					json.put("Produtos", jsonList);
					
				});
				
				System.out.println(json);
			});
		}
	}
}
