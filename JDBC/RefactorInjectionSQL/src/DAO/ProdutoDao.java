package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.ProdutoModel;

public class ProdutoDao {
	
	private Connection connection;

	public ProdutoDao(Connection connection) {
		this.connection = connection;
	}
	
	
	public void Salvar(ProdutoModel produto) throws SQLException {
		String sql = "INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)";
		
		try(PreparedStatement prepa = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			prepa.setString(1, produto.getNome());
			prepa.setString(2,produto.getDescricao());
			
			prepa.execute();
			
			try(ResultSet result = prepa.getGeneratedKeys()){
				while (result.next()) {
					produto.setId(result.getInt(1));
				}
			}
		}
	}
	
	public List<ProdutoModel> listarProduto() throws SQLException{
		List<ProdutoModel> produtoList = new ArrayList<ProdutoModel>();
		
		String sql = "SELECT id, nome, descricao from produto";
		
		try(PreparedStatement prepara = connection.prepareStatement(sql)){
			prepara.execute();
			
			try(ResultSet set = prepara.getResultSet())
			{
				while (set.next()) {
					ProdutoModel prod = 
							new ProdutoModel(set.getInt(1), set.getString(2), set.getString(3));
					produtoList.add(prod);
				}
			}
		}
		return produtoList;
	}
	

}
