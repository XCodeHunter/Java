package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.CategoriaModel;
import Model.ProdutoModel;

public class CategoriaDAO {

	private Connection connection;
	
	public CategoriaDAO() {
		
	}

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(CategoriaModel categoria) throws SQLException {
		String sql ="INSERT INTO CATEGORIA (ID,NOME) VALUES (?,?)";
		
		try(PreparedStatement prepa = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			prepa.setString(1, categoria.getNome());
			
			try(ResultSet result = prepa.getGeneratedKeys()){
				while (result.next()) {
					categoria.setId(result.getInt(1));
				}
			}
		}
	}
	
	
	public List<CategoriaModel> listarCategoria() throws SQLException{
		CategoriaModel ultima = null;
		List<CategoriaModel> listCategoria = new ArrayList<CategoriaModel>();
		
		String sql = "SELECT C.ID, C.NOME, P.ID,P.NOME,P.DESCRICAO FROM CATEGORIA C INNER JOIN"
				+ " PRODUTO P ON C.ID = P.IDCATEGORIA";
		
		try(PreparedStatement prepa = connection.prepareStatement(sql)){
			prepa.execute();
			
			try(ResultSet result = prepa.getResultSet())
			{
				while (result.next()) {
					
					if (ultima == null || !ultima.getNome().equals(result.getString(2))) {
						CategoriaModel categoria =
								new CategoriaModel(result.getInt(1), result.getString(2));
						ultima = categoria;
						listCategoria.add(categoria);
					}
					ProdutoModel prod = 
							new ProdutoModel(result.getInt(3), result.getString(4), result.getString(5));
					ultima.adicionar(prod);
				}
			}
		}
		
		return listCategoria;
	}
	
}
