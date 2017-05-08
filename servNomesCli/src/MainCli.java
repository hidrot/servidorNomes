import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainCli {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			String ip;
			int porta;
			System.out.println("Digite o IP em que se encontra o Servidor de DNS\n");
			ip = new Scanner(System.in).next();
			System.out.println("Digite a porta para se acessar o Servidor de DNS\n");
			porta = new Scanner(System.in).nextInt();
			MsgServDNS servDns = (MsgServDNS) Naming.lookup("rmi://" + ip + ":" + porta + "/ServDNS");

			while (true) {
				System.out.println("MENU\n0 - M�dia\n1 - Maior\n2 - Menor\n3 - Primos\n9 - Sair\n");
				int tipoServico = new Scanner(System.in).nextInt();
				String enderecoServico = servDns.pegaEndereco(tipoServico);
				if (enderecoServico != null) {
					MsgServicos servServico = (MsgServicos) Naming.lookup("rmi://" + enderecoServico + "/ServApps");
					RespostaServicos resp = null;
					switch (tipoServico) {
					case 0:// media
					{
						ArrayList<Double> valores = new ArrayList<Double>();
						while (true) {
							System.out.println("Digite um n�mero para calcular a m�dia ou I para iniciar o c�lculo");
							String entrada = new Scanner(System.in).next();
							if (entrada.charAt(0) == 'I' || entrada.charAt(0) == 'i') {
								if (valores.size() > 1) {
									break;
								} else {
									System.out.println("Quantidade de valores inseridos insuficiente");
								}
							} else {
								valores.add(Double.parseDouble(entrada.replace(',', '.')));
							}
						}
						resp = servServico.media(valores);
					}
						break;
					case 1:// maior
					{
						ArrayList<Double> valores = new ArrayList<Double>();
						while (true) {
							System.out.println("Digite um n�mero para calcular o maior ou I para iniciar o c�lculo");
							String entrada = new Scanner(System.in).next();
							if (entrada.charAt(0) == 'I' || entrada.charAt(0) == 'i') {
								if (valores.size() > 1) {
									break;
								} else {
									System.out.println("Quantidade de valores inseridos insuficiente");
								}
							} else {
								valores.add(Double.parseDouble(entrada.replace(',', '.')));
							}
						}
						resp = servServico.maior(valores);
					}
						break;
					case 2:// menor
					{
						ArrayList<Double> valores = new ArrayList<Double>();
						while (true) {
							System.out.println("Digite um n�mero para calcular o menor ou I para iniciar o c�lculo");
							String entrada = new Scanner(System.in).next();
							if (entrada.charAt(0) == 'I' || entrada.charAt(0) == 'i') {
								if (valores.size() > 1) {
									break;
								} else {
									System.out.println("Quantidade de valores inseridos insuficiente");
								}
							} else {
								valores.add(Double.parseDouble(entrada.replace(',', '.')));
							}
						}
						resp = servServico.menor(valores);
					}
						break;
					case 3:// primos
					{
						ArrayList<Integer> valores = new ArrayList<Integer>();
						while (true) {
							System.out.println(
									"Digite um n�mero para receber quantos primos foram digitados, ou I para iniciar o c�lculo");
							String entrada = new Scanner(System.in).next();
							if (entrada.charAt(0) == 'I' || entrada.charAt(0) == 'i') {
								if (valores.size() > 0) {
									break;
								} else {
									System.out.println("Quantidade de valores inseridos insuficiente");
								}
							} else {
								valores.add(Integer.parseInt(entrada));
							}
						}
						resp = servServico.primos(valores);
					}
						break;
					case 9:
						System.exit(0);
					}
					System.out.println("Status: " + resp.getStatus() + "\nResultado Servico: " + resp.getResultado());
				} else {
					System.out.println("N�o h� um Servidor com o Servi�o Requisitado");
				}
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}
