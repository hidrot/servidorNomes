
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.Scanner;

public class ThreadMain implements Runnable {

	private String ipDNS;
	private int portaDNS, porta;
	private ServidorApp servApp;
	private ArrayList<Integer> funcoes;

	@SuppressWarnings("resource")
	public ThreadMain() {
		System.out.println("Informe o ip no qual o Servidor de DNS se encontra\n");
		this.ipDNS = new Scanner(System.in).next();
		System.out.println("Informe a porta no qual o Servidor de DNS se encontra\n");
		this.portaDNS = new Scanner(System.in).nextInt();
		System.out.println("Informe a porta que esta aplicação utilizará\n");
		this.porta = new Scanner(System.in).nextInt();
		try {
			LocateRegistry.createRegistry(porta);
		} catch (RemoteException e) {
			e.printStackTrace();
			System.exit(0);
		}
		servApp = new ServidorApp(porta);
		funcoes = new ArrayList<Integer>();
	}

	@Override
	public void run() {
	}

	public int registra() {
		int retorno;
		try {
			servApp.setServicos(this.funcoes);

			MsgServDNS servDns = (MsgServDNS) Naming.lookup("rmi://" + ipDNS + ":" + portaDNS + "/ServDNS");
			retorno = servDns.registraServidor(servApp);
			MsgServicos servicos = new Bind(servDns, servApp);
			Naming.rebind("rmi://" + servApp.getEndereco() + "/ServApps", servicos);
			return retorno;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int desregistra() {
		try {
			MsgServDNS servDns = (MsgServDNS) Naming.lookup("rmi://" + ipDNS + ":" + portaDNS + "/ServDNS");
			return servDns.desregistraServidor(servApp);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public void servicos(String[] entrada) {
		this.funcoes.clear();
		for (int i = 0; i < entrada.length; i++) {
			this.funcoes.add(Integer.parseInt(entrada[i]));
		}
		System.out.println("AVISO, as alterações só serão efetivadas quando o servidor for registrado novamente.");
	}
}