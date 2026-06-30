package ProjetoFinal.model;

public class CremePentear extends Produto{

	public CremePentear(int id, String nome, int tipo, float preco) {
		super(id, nome, tipo, preco);
	}
 @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Categoria: Creme");
    }
}
