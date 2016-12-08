package modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria2 {

	private Integer id;
	private String nome;
	private final List<Produto> produtos = new ArrayList<>();
	
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
	
	public List<Produto> getProdutos(){
		
		return this.produtos;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ID: " + id +" NOME: " + nome +" ]";
	}
	public void adiciona(Produto produto) {
		
		this.produtos.add(produto);
		
	}
}
