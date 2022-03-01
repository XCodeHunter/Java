package br.com.connection;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteCrudConnection {
    
    public static void main(String[] args) throws SQLException {
        //Recuperando conexão com o banco de dados MYSQL
        ConnectionFactory conex = new ConnectionFactory();
        Connection con = conex.criarConexao();
        //Instacia de statement para pegar a lista do banco de dados.
        Statement state = con.createStatement();

        //Inserindo um dado
        //state.execute("INSERT INTO PRODUTO (nome,descricao) VALUES ('Celular','Iphone 12')");

        //Listando o que está salvo
        state.execute("SELECT ID,NOME,DESCRICAO FROM PRODUTO");

        //Capturando o resultado e setando no result
        ResultSet resultSet =  state.getResultSet();

        //Realizando laço de repetição para mostrar na tela o resultado.
        for (int i = 0; resultSet.next(); i++) {

            Integer id = resultSet.getInt("ID");
            System.out.println(id);
            String nome = resultSet.getString("NOME");
            System.out.println(nome);
            String descricao = resultSet.getString("DESCRICAO");
            System.out.println(descricao);
        }

        //Deletando um dado
        //state.execute("DELETE FROM PRODUTO WHERE ID = 3", Statement.SUCCESS_NO_INFO);
        con.close();
    }
}