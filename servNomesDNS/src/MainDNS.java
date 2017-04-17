
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MainDNS {
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(9898);
			ServidorDNS servDNS = new ServidorDNS();
			MsgServDNS prot = new Bind(servDNS);
			Naming.rebind("rmi://localhost:9898/ServDNS", prot);
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
}