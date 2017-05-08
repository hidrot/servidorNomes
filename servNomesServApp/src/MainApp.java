import java.util.Scanner;

public class MainApp {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ThreadMain tm = new ThreadMain();
		Thread t = new Thread(tm);
		t.start();
		String menu = "I - Iniciar\nP - Parar\nA - Alterar Serviços do Servidor\nS - Sair de tudo\nH- Exibir este menu";
		System.out.println(menu);
		while (true) {
			switch (new Scanner(System.in).next().toUpperCase().charAt(0)) {
			case 'I':
				switch (tm.registra()) {
				case 0:
					System.out.println("Servidor de Aplicação registrado com sucesso");
					break;
				case 1:
					System.out.println("Erro ao registrar o Servidor de Aplicação - Não há Serviços disponíveis");
					break;
				case 2:
					System.out.println("Erro ao registrar o Servidor de Aplicação - Servidor já registrado");
					break;
				}
				break;
			case 'P':
				switch (tm.desregistra()) {
				case 0:
					System.out.println("Servidor de Aplicação desregistrado com sucesso");
					break;
				case 1:
					System.out.println("Erro ao desregistrar Servidor de Aplicação - Servidor não registrado");
					break;
				}
				break;
			case 'A':
				System.out.println(
						"Digite o número das funções desejadas, separando-as por vírgula\n0 - Média\n1 - Maior\n2 - Menor\n3 - Primos");
				tm.servicos(new Scanner(System.in).next().split(","));
				System.out.println("Serviços alterados");
				break;
			case 'S':
				System.exit(0);
				break;
			case 'H':
				System.out.println(menu);
				break;
			default:
				System.out.println("Opção Inválida");
				break;
			}
		}
	}
}