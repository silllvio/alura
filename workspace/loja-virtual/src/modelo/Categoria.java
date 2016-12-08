package modelo;

public class Categoria {

	private String nome;
	public  String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private Integer id;

	public Categoria(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ ID: " + id + " NOME: " + nome;
	}
}
