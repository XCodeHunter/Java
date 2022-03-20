package Model;

import java.util.ArrayList;
import java.util.List;

public class CategoriaModel {
	
	private Integer id;
	private String nome;
	private List<ProdutoModel> produtos = new ArrayList<ProdutoModel>();
	
	public CategoriaModel() {
		
	}
	
	public CategoriaModel(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void adicionar(ProdutoModel prod) {
		produtos.add(prod);
	}

	public List<ProdutoModel> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoModel> produtos) {
		this.produtos = produtos;
	}
}
