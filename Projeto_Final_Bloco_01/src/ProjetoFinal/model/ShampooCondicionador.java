package ProjetoFinal.model;

public class ShampooCondicionador extends Produto {

    public ShampooCondicionador(int id, String nome, int tipo, float preco) {
        super(id, nome, tipo, preco);
    }

    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Categoria: Shampoo e Condicionador");
    }
}
