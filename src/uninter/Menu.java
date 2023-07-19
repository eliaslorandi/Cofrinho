package uninter;

import java.util.Scanner;

public class Menu {

	private Scanner sc;
	private Cofrinho cofrinho;

	public Menu() {
		sc = new Scanner(System.in);
		cofrinho = new Cofrinho();
	}

	public void exibirMenuPrincipal() {
		System.out.println("---- COFRINHO ----");
		System.out.println("1 - Adicionar moeda");
		System.out.println("2 - Remover moeda");
		System.out.println("3 - Listar moedas");
		System.out.println("4 - Calcular valor total convertido para Real");
		System.out.println("0 - Encerrar");

		String opcaoSelecionada = sc.next();
		
		//case utilizado para mostrar as opcoes do inicio do programa
		switch (opcaoSelecionada) {
		case "1":
			exibirSubMenuEscolhaMoeda();
			exibirMenuPrincipal();
			break;

		case "2":
			exibirSubMenuRemoverMoeda();
			exibirMenuPrincipal();
			break;

		case "3":
			cofrinho.listagemMoedas();
			exibirMenuPrincipal();
			break;

		case "4":
			double valorTotalConvertido = cofrinho.totalConvertido();
			
			//irá converter para duas casas decimais
			String valorTotalConvertidoTextual = String.format("%.2f", valorTotalConvertido);
			
			//trocará o ponto por vírgula para se adequar ao sistema brasileiro
			valorTotalConvertidoTextual = valorTotalConvertidoTextual.replace(".", ",");
			System.out.println("O valor total convertido para real: " + valorTotalConvertidoTextual);
			exibirMenuPrincipal();
			break;
			
		case "0":
			System.out.println("Encerrando sistema...");
			break;

		default:
			System.out.println("Opcao invalida!");
			exibirMenuPrincipal();
			break;

		}
	}

	//menu para acidionar a moeda desejada
	private void exibirSubMenuEscolhaMoeda() {
		System.out.println("Escolha uma moeda para adicionar:");
		System.out.println("1 - Real");
		System.out.println("2 - Dolar");
		System.out.println("3 - Euro");

		int opcaoMoeda = sc.nextInt();
		System.out.println("Digite o valor: ");
		String valorTextoMoeda = sc.next();
		
		//substitui a virgula pelo ponto para o java reconhecer
		valorTextoMoeda = valorTextoMoeda.replace(",", ".");
		double valorMoeda = Double.valueOf(valorTextoMoeda);

		Moeda moeda = null;

		if (opcaoMoeda == 1) {
			moeda = new Real(valorMoeda);
		} else if (opcaoMoeda == 2) {
			moeda = new Dolar(valorMoeda);
		} else if (opcaoMoeda == 3) {
			moeda = new Euro(valorMoeda);
		} else {
			System.out.println("Moeda inexistente!");
		}

		cofrinho.adicionar(moeda);
		System.out.println("Moeda adicionada com sucesso!");
	}

	private void exibirSubMenuRemoverMoeda() {
		System.out.println("Escolha uma moeda para remover:");
		System.out.println("1 - Real");
		System.out.println("2 - Dolar");
		System.out.println("3 - Euro");

		int opcaoMoeda = sc.nextInt();
		System.out.println("Digite o valor: ");

		String valorTextoMoeda = sc.next();

		valorTextoMoeda = valorTextoMoeda.replace(",", ".");
		double valorMoeda = Double.parseDouble(valorTextoMoeda);

		Moeda moeda = null;

		if (opcaoMoeda == 1) {
			moeda = new Real(valorMoeda);
		} else if (opcaoMoeda == 2) {
			moeda = new Dolar(valorMoeda);
		} else if (opcaoMoeda == 3) {
			moeda = new Euro(valorMoeda);
		} else {
			System.out.println("Moeda inexistente!");
		}

		boolean removeuMoeda = cofrinho.remover(moeda);

		if (removeuMoeda) {
			System.out.println("Moeda removida!");
		} else {
			System.out.println("A moeda escolhida nao foi encontrada!");
		}

	}

}