package ProjetoFinal.model;

public class Mascara extends Produto {

    public Mascara(int id, String nome, int tipo, float preco) {
        super(id, nome, tipo, preco);
    }

    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Categoria: Máscara");
    }
}
