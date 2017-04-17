import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Bind extends UnicastRemoteObject implements MsgServicos {

	protected Bind() throws RemoteException {
		super();
	}

	@Override
	public RespostaServicos media(ArrayList<Double> valores) {
		if (valores == null || valores.size() == 0) {
			return new RespostaServicos(1, 0);
		}
		double soma = 0;
		try {
			for (int i = 0; i < valores.size(); i++) {
				soma += valores.get(i);
			}
			return new RespostaServicos(0, soma / valores.size());
		} catch (Exception e) {
			e.printStackTrace();
			return new RespostaServicos(2, 0);
		}
	}

	@Override
	public RespostaServicos maior(ArrayList<Double> valores) {
		if (valores == null || valores.size() == 0) {
			return new RespostaServicos(1, 0);
		}
		try {
			double maior = valores.get(0);
			if (valores.size() > 1) {
				for (int i = 1; i < valores.size(); i++) {
					if (valores.get(i) > maior) {
						maior = valores.get(i);
					}
				}
			}
			return new RespostaServicos(0, maior);
		} catch (Exception e) {
			e.printStackTrace();
			return new RespostaServicos(2, 0);
		}
	}

	@Override
	public RespostaServicos menor(ArrayList<Double> valores) {
		if (valores == null || valores.size() == 0) {
			return new RespostaServicos(1, 0);
		}
		try {
			double menor = valores.get(0);
			if (valores.size() > 1) {
				for (int i = 1; i < valores.size(); i++) {
					if (valores.get(i) < menor) {
						menor = valores.get(i);
					}
				}
			}
			return new RespostaServicos(0, menor);
		} catch (Exception e) {
			e.printStackTrace();
			return new RespostaServicos(2, 0);
		}
	}

	@Override
	public RespostaServicos primos(ArrayList<Integer> valores) {
		if (valores == null || valores.size() == 0) {
			return new RespostaServicos(1, 0);
		}
		try {
			int contPrimos = 0, contDivisores;
			for (int i = 0; i < valores.size(); i++) {
				contDivisores = 0;
				for (int h = 1; h <= valores.get(i); h++) {
					if (valores.get(i) % h == 0) {
						contDivisores++;
					}
				}
				if (contDivisores == 2) {
					contPrimos++;
				}
			}
			return new RespostaServicos(0, contPrimos);
		} catch (Exception e) {
			e.printStackTrace();
			return new RespostaServicos(2, 0);
		}
	}
}
