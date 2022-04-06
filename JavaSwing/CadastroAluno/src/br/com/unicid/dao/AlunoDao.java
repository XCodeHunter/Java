package br.com.unicid.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.unicid.model.AlunoModel;
import br.com.unicid.util.ConnectionFactory;

public class AlunoDao {

	private Connection connection;

	public AlunoDao() {
		try {
			connection = new ConnectionFactory().estabeleceConexao();
			
		} catch (Exception e) {
		}
		
	}

	public List<AlunoModel> listar(){
		try {
			List<AlunoModel> alunoList = new ArrayList<>();
			String sql = "";
			
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();
				
				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						AlunoModel aluno = new AlunoModel(rst.getInt(1), rst.getString(2), rst.getDate(3), 
								rst.getLong(4), rst.getString(5), rst.getLong(6));
						
						alunoList.add(aluno);
					}
				}
			}
			return alunoList;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public void salvar(AlunoModel aluno)  {	
		try {
			String sql = "";
			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				
				pstm.setString(1, aluno.getNome());
				pstm.setString(2, aluno.getEmail());
				pstm.setLong(4, aluno.getCelular());
				pstm.setLong(5, aluno.getCpf());
				pstm.setDate(6, (Date) aluno.getDataNascimento());
				
				pstm.execute();
				
				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						aluno.setRGM(rst.getInt(1));
					}
				}
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
