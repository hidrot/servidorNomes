
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Bind extends UnicastRemoteObject implements MsgServDNS {

	private static final long serialVersionUID = 1L;
	private ServidorDNS sdns;

	protected Bind(ServidorDNS sdns) throws RemoteException {
		super();
		this.sdns = sdns;
	}

	public String pegaEndereco(int tipo) {
		return sdns.getServico(tipo);
	}

	public int registraServidor(ServidorApp serv) {
		return sdns.registraServidor(serv);
	}

	public int desregistraServidor(ServidorApp serv) {
		return sdns.desregistraServidor(serv);
	}

	public void mudaStatusServ(ServidorApp serv) throws RemoteException {
		sdns.mudaStatusServ(serv);
	}
}
