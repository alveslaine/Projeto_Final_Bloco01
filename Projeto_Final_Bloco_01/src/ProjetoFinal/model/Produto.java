package ProjetoFinal.model;

public abstract class Produto {
	private int id;
	private String nome;
	private int tipo;
	private float preco;
	
	public Produto(int id, String nome, int tipo, float preco) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public void visualizar() {
		String tipo = "";
		
		switch(this.tipo){
		case 1:
		tipo = "Mascara de Tratamento";
		break;
		
		case 2:
		tipo = "Shampoo e Condicionador";
		break;
		
		case 3:
		tipo = "Creme para Pentear";
		break;
	}
		System.out.printf("=======================================================\n");
		System.out.printf("                    DADOS DO PRODUTO                   \n");
		System.out.printf("=======================================================\n");
		System.out.printf("ID do produto: %d%n", this.id);
		System.out.printf("Nome do produto: %s%n", this.nome);
		System.out.printf("Tipo de Produto: %d%n", this.tipo);
		System.out.printf("Valor do produto: %.2f%n", this.preco);

	}
}
