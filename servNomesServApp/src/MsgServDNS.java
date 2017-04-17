import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MsgServDNS extends Remote {

	public int registraServidor(ServidorApp serv) throws RemoteException;
}
