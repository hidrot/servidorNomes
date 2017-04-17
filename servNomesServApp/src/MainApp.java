import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

public class MainApp {
	public static void main(String[] args) {
		try {
			int porta = 10000;
			LocateRegistry.createRegistry(porta);

			ArrayList funcoes = new ArrayList();
			funcoes.add(0);
			funcoes.add(1);
			funcoes.add(2);
			funcoes.add(3);

			ServidorApp servApp = new ServidorApp(porta, funcoes);
			MsgServDNS servDns = (MsgServDNS) Naming.lookup("rmi://172.16.147.77:9898/ServDNS");
			servDns.registraServidor(servApp);
			MsgServicos servicos = new Bind();
			Naming.rebind("rmi://" + servApp.getEndereco() + "/ServApps", servicos);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}