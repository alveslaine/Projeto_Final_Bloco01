package ProjetoFinal;

import java.util.InputMismatchException;
import java.util.Scanner;

import ProjetoFinal.util.Cores;

public class menu {
	private static final Scanner leia = new Scanner (System.in);
		
		public static void main(String[] args) {
			
			int opcao;

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
						keyPress();
						break;
					case 2:
						System.out.println(Cores.TEXT_PINK +"Listar Todos os Produtos\n" + Cores.TEXT_RESET);
						keyPress();
						break;
					case 3:
						System.out.println(Cores.TEXT_PINK +"Consultar Produto pelo ID" + Cores.TEXT_RESET);
						keyPress();
						break;
					case 4:
						System.out.println(Cores.TEXT_PINK +"Atualizar dados do Produto\n" + Cores.TEXT_RESET);
						keyPress();
						break;
					case 5:
						System.out.println(Cores.TEXT_PINK +"Deletar Produto\n" + Cores.TEXT_RESET);
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
	}
