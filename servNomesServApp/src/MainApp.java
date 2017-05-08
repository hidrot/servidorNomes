import java.util.Scanner;

public class MainApp {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ThreadMain tm = new ThreadMain();
		Thread t = new Thread(tm);
		t.start();
		String menu = "I - Iniciar\nP - Parar\nA - Alterar Servi�os do Servidor\nS - Sair de tudo\nH- Exibir este menu";
		System.out.println(menu);
		while (true) {
			switch (new Scanner(System.in).next().toUpperCase().charAt(0)) {
			case 'I':
				switch (tm.registra()) {
				case 0:
					System.out.println("Servidor de Aplica��o registrado com sucesso");
					break;
				case 1:
					System.out.println("Erro ao registrar o Servidor de Aplica��o - N�o h� Servi�os dispon�veis");
					break;
				case 2:
					System.out.println("Erro ao registrar o Servidor de Aplica��o - Servidor j� registrado");
					break;
				}
				break;
			case 'P':
				switch (tm.desregistra()) {
				case 0:
					System.out.println("Servidor de Aplica��o desregistrado com sucesso");
					break;
				case 1:
					System.out.println("Erro ao desregistrar Servidor de Aplica��o - Servidor n�o registrado");
					break;
				}
				break;
			case 'A':
				System.out.println(
						"Digite o n�mero das fun��es desejadas, separando-as por v�rgula\n0 - M�dia\n1 - Maior\n2 - Menor\n3 - Primos");
				tm.servicos(new Scanner(System.in).next().split(","));
				System.out.println("Servi�os alterados");
				break;
			case 'S':
				System.exit(0);
				break;
			case 'H':
				System.out.println(menu);
				break;
			default:
				System.out.println("Op��o Inv�lida");
				break;
			}
		}
	}
}