
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class MainDNS {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String ip;
		int porta;
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
			System.out.println("Digite a porta que este Servidor de DNS utilizará");
			porta = new Scanner(System.in).nextInt();
			LocateRegistry.createRegistry(porta);
			ServidorDNS servDNS = new ServidorDNS();
			MsgServDNS prot = new Bind(servDNS);
			Naming.rebind("rmi://" + ip + ":9898/ServDNS", prot);
			System.out.println("Servidor de DNS aberto\nIP: " + ip + "\nPorta: " + porta);
		} catch (RemoteException | MalformedURLException | UnknownHostException e) {
			e.printStackTrace();
		}
	}
}