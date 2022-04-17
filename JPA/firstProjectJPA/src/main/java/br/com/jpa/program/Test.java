package br.com.jpa.program;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import org.json.JSONObject;

import br.com.jpa.dao.CategoriaDao;
import br.com.jpa.dao.ProdutoDao;
import br.com.jpa.model.Categoria;
import br.com.jpa.model.Produto;
import br.com.jpa.util.JPAUtil;

public class Test {	

	public static void main(String[] args) {
		cadastrarProduto();
		
		EntityManager entity = JPAUtil.getEntityManeger();
		ProdutoDao p = new ProdutoDao(entity);
		
		Produto pro =  p.buscarPorId(1l);
		System.out.println(pro);
		
		List<Produto> listall = p.findAllCompanyAndDescription("Santander", "a");
		listall.forEach((a) -> {
			
			System.out.println("Passou no find por empresa");
			System.out.println(a);
		}
		);
		
		List<Produto> listParametro = p.buscarPorParametros("", new BigDecimal(12), null);
		listParametro.forEach(parametros -> {
			JSONObject json = new JSONObject();
			json.put("Nome", parametros.getNome());
			json.put("Descricao", parametros.getDescricao());
			json.put("Preco", parametros.getPreco());
			json.put("Categoria", parametros.getCategoria().getNome());
			System.out.println(json);
		} );
	}
	
	public static void cadastrarProduto() {
		
		Categoria categoria = new Categoria();
		categoria.setNome("bitela");
		
		Produto produto = new Produto();
		produto.setDescricao("a");
		produto.setNome("a");
		produto.setPreco(new BigDecimal(12.00));
		produto.setCategoria(categoria);

		EntityManager entity = JPAUtil.getEntityManeger();
		CategoriaDao categoriaDAO = new CategoriaDao(entity);
		ProdutoDao dao = new ProdutoDao(entity);
		
		entity.getTransaction().begin();
		
		categoriaDAO.cadastrar(categoria);
		dao.cadastrar(produto);
		
		entity.getTransaction().commit();
		entity.close();
	}

}
