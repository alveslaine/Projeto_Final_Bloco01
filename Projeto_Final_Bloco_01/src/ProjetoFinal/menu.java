package ProjetoFinal;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import ProjetoFinal.Controller.HairMagiaController;
import ProjetoFinal.model.CremePentear;
import ProjetoFinal.model.Mascara;
import ProjetoFinal.model.Produto;
import ProjetoFinal.model.ShampooCondicionador;
import ProjetoFinal.util.Cores;

public class menu {
	private static final Scanner leia = new Scanner(System.in);
	private static String entrada;
	private static HairMagiaController hairMagiaController = new HairMagiaController();
		
		public static void main(String[] args) {
			
			int opcao;
			criarProdutosTeste();

			while (true) {
				System.out.println(Cores.TEXT_WHITE +"=======================================================");
				System.out.println("                      Hair Magia                       ");
				System.out.println("=======================================================");
				System.out.println(Cores.TEXT_PINK+"           1 - Cadastrar Produto                          ");
				System.out.println("           2 - Listar Todos os Produtos               ");
				System.out.println("           3 - Buscar Produto pelo ID              ");
				System.out.println("           4 - Atualizar Produto             ");
				System.out.println("           5 - Deletar Produto                         ");
				System.out.println("           0 - Sair                                 " + Cores.TEXT_RESET);
				System.out.println("=======================================================");
				System.out.printf("Entre com a opção desejada: ");
				try {
				opcao = leia.nextInt();
				leia.nextLine();
				}catch(InputMismatchException e) {
					opcao = -1;
					System.out.println("Digite um numero inteiro entre 0 e 5");
					leia.nextLine();
				}
				if (opcao == 0) {
					System.out.println("\nHair Magia agradece sua visita!");
					sobre();
	                 leia.close();
					System.exit(0);
				}
				switch (opcao) {
					case 1:
						System.out.println(Cores.TEXT_PINK + "Cadastrar Produto\n" + Cores.TEXT_RESET);
						cadastrarProduto();
						keyPress();
						break;
					case 2:
						System.out.println(Cores.TEXT_PINK +"Listar Todos os Produtos\n" + Cores.TEXT_RESET);
						ListarProdutos();
						keyPress();
						break;
					case 3:
						System.out.println(Cores.TEXT_PINK +"Consultar Produto pelo ID" + Cores.TEXT_RESET);
						procurarPorID();
						keyPress();
						break;
					case 4:
						System.out.println(Cores.TEXT_PINK +"Atualizar dados do Produto\n" + Cores.TEXT_RESET);
						atualizarProduto();
						keyPress();
						break;
					case 5:
						System.out.println(Cores.TEXT_PINK +"Deletar Produto\n" + Cores.TEXT_RESET);
						deletarProduto();
						keyPress();
						break;
					default:
						System.out.println(Cores.TEXT_RED_BOLD +"\nOpção Inválida!\n" + Cores.TEXT_RESET);
						break;
				}
			}
		}
		public static void sobre() {
			System.out.println("=======================================================");
			System.out.println(Cores.TEXT_PINK +"Projeto Desenvolvido por: Elaine Alves");
			System.out.println("Generation Brasil - generation@generation.org");
			System.out.println("github.com/conteudoGeneration" + Cores.TEXT_RESET);
			System.out.println("=======================================================");
		}  
		public static void keyPress() {
			System.out.println(Cores.TEXT_PINK + "\nPressione Enter para continuar..." + Cores.TEXT_RESET);
			leia.nextLine();
		}
		
		public static void criarProdutosTeste() {

		}		
		public static void ListarProdutos() {
			    hairMagiaController.listarTodas();
		}
		public static void cadastrarProduto() {

		    System.out.printf("Digite o nome do Produto: ");
		    String nome = leia.next();

		    System.out.printf("Digite o valor do produto: ");
		    float preco = leia.nextFloat();

		    System.out.printf("Digite o tipo de produto (1-Mascara / 2-ShampooCond / 3-Creme): ");
		    int tipo = leia.nextInt();
		    switch (tipo) {
		        case 1:
		            hairMagiaController.cadastrar(
		                new Mascara(hairMagiaController.gerarId(), nome, tipo, preco));
		            break;

		        case 2:
		            hairMagiaController.cadastrar(
		                new ShampooCondicionador(hairMagiaController.gerarId(), nome, tipo, preco));
		            break;

		        case 3:
		            hairMagiaController.cadastrar(
		                new CremePentear(hairMagiaController.gerarId(), nome, tipo, preco));
		            break;

		        default:
		            System.out.println("Tipo de produto inválido!");
		    }
		}
		public static void procurarPorID() {
			System.out.printf("Digite o ID do produto: ");
			int id = leia.nextInt();
			leia.nextLine();
			
			hairMagiaController.procurarPorID(id);
		}
		public static void deletarProduto() {
			System.out.printf("Digite o ID do produto a ser deletado: ");
			int id = leia.nextInt();
			leia.nextLine();
			
			Optional<Produto> produto = hairMagiaController.buscarNaCollection(id);
			if (produto.isPresent()) {
				System.out.printf("\nTem certeza que voce deseja excluir o produto %d? (S / N)", id);
				String confirmacao = leia.nextLine();
				
				if (confirmacao.equalsIgnoreCase("S"))
					hairMagiaController.deletar(id);
				else
					System.out.println("\nOperacao cancelada!");
			}else {
				System.out.printf("\nO produto com o ID %d nao foi encontrado!",id);
			}
		}
		public static void atualizarProduto() {
		    System.out.printf("Digite o ID do produto: ");
		    int id = leia.nextInt();
		    leia.nextLine();

		    Optional<Produto> produto = hairMagiaController.buscarNaCollection(id);
		    if (produto.isPresent()) {
		        String nome = produto.get().getNome();
		        int tipo = produto.get().getTipo();
		        float preco = produto.get().getPreco();

		        System.out.printf("Nome atual: %s" + "%nDigite o novo nome (ENTER para manter): ", nome);
		        String entrada = leia.nextLine();

		        nome = entrada.isEmpty() ? nome : entrada;

		        System.out.printf("Preço atual: %.2f" + "%nDigite o novo preço (ENTER para manter): ", preco);
		        entrada = leia.nextLine();
		        preco = entrada.isEmpty() ? preco : Float.parseFloat(entrada.replace(",", "."));
		        Produto produtoAtualizado = null;
		        switch (tipo) {
		            case 1:
		                produtoAtualizado = new Mascara(id, nome, tipo, preco);
		                break;
		            case 2:
		                produtoAtualizado = new ShampooCondicionador(id, nome, tipo, preco);
		                break;
		            case 3:
		                produtoAtualizado = new CremePentear(id, nome, tipo, preco);
		                break;
		        }
		        hairMagiaController.atualizar(produtoAtualizado);
		        System.out.println("\nProduto atualizado com sucesso!");
		    } else {
		        System.out.printf("\nO produto com o ID %d nao foi encontrado!", id);
		    }
		}
}
