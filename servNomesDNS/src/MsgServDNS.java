import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MsgServDNS extends Remote {

	public String pegaEndereco(int servico) throws RemoteException;

	public int registraServidor(ServidorApp serv) throws RemoteException;

	public int desregistraServidor(ServidorApp serv) throws RemoteException;

	public void mudaStatusServ(ServidorApp serv) throws RemoteException;
}
