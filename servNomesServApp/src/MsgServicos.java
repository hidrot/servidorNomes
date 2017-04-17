import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MsgServicos extends Remote {

	public RespostaServicos media(ArrayList<Double> valores) throws RemoteException;// 0

	public RespostaServicos maior(ArrayList<Double> valores) throws RemoteException;// 1

	public RespostaServicos menor(ArrayList<Double> valores) throws RemoteException;// 2

	public RespostaServicos primos(ArrayList<Integer> valores) throws RemoteException;// 3
}
