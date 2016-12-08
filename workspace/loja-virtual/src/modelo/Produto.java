package modelo;

public class Produto {
	
	private Integer id;
	private String nome;
	private String descricao;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getId() {
		return id;
	}
	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	public void setId(int id2) {
		this.id = id2;
	}

	@Override
	public String toString() {
		return "[ id: "+ this.id + " nome: "  + this.nome + "]";
	}
	public Produto busca(Categoria2 cat) {
		Produto produto = new Produto(nome, descricao);
		return produto;
	}
	
}
