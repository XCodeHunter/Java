package br.com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.example.model.LeitorModel;
import br.com.example.util.ConnectionFactory;

public class LeitorDao {

	private Connection connection;

	public LeitorDao() {
		try {
			connection = new ConnectionFactory().criaConexao();
			
		} catch (Exception e) {
		}
		
	}

	public List<LeitorModel> listar(){
		try {
			List<LeitorModel> leitorList = new ArrayList<>();
			String sql = "SELECT idLeitor, nomeLeitor, tipoLeitor FROM leitor";
			
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();
				
				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						LeitorModel leitor = new LeitorModel(rst.getInt(1), rst.getString(2), rst.getString(3));
						
						leitorList.add(leitor);
					}
				}
			}
			return leitorList;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public void salvar(LeitorModel leitor)  {	
		try {
			String sql = "INSERT INTO leitor (nomeLeitor, tipoLeitor) VALUES (?, ?)";
			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				
				pstm.setString(1, leitor.getNomeLeitor());
				pstm.setString(2, leitor.getTipoLeitor());
				
				pstm.execute();
				
				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						leitor.setIdLeitor(rst.getInt(1));
					}
				}
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
