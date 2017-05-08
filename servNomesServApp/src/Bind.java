import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Bind extends UnicastRemoteObject implements MsgServicos {

	private static final long serialVersionUID = 1L;
	private MsgServDNS servDns;
	private ServidorApp servApp;

	protected Bind(MsgServDNS servDns, ServidorApp servApp) throws RemoteException {
		super();
		this.servDns = servDns;
		this.servApp = servApp;
	}

	@Override
	public RespostaServicos media(ArrayList<Double> valores) {
		mudaStatus();
		if (valores == null || valores.size() == 0) {
			mudaStatus();
			return new RespostaServicos(1, 0);
		}
		double soma = 0;
		try {
			for (int i = 0; i < valores.size(); i++) {
				soma += valores.get(i);
			}
			mudaStatus();
			return new RespostaServicos(0, soma / valores.size());
		} catch (Exception e) {
			e.printStackTrace();
			mudaStatus();
			return new RespostaServicos(2, 0);
		}
	}

	@Override
	public RespostaServicos maior(ArrayList<Double> valores) {
		if (valores == null || valores.size() == 0) {
			mudaStatus();
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
			mudaStatus();
			return new RespostaServicos(0, maior);
		} catch (Exception e) {
			e.printStackTrace();
			mudaStatus();
			return new RespostaServicos(2, 0);
		}
	}

	@Override
	public RespostaServicos menor(ArrayList<Double> valores) {
		if (valores == null || valores.size() == 0) {
			mudaStatus();
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
			mudaStatus();
			return new RespostaServicos(0, menor);
		} catch (Exception e) {
			e.printStackTrace();
			mudaStatus();
			return new RespostaServicos(2, 0);
		}
	}

	@Override
	public RespostaServicos primos(ArrayList<Integer> valores) {
		if (valores == null || valores.size() == 0) {
			mudaStatus();
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
			mudaStatus();
			return new RespostaServicos(0, contPrimos);
		} catch (Exception e) {
			e.printStackTrace();
			mudaStatus();
			return new RespostaServicos(2, 0);
		}
	}

	private void mudaStatus() {
		if (this.servApp.isOcupado()) {
			this.servApp.setOcupado(false);
		} else {
			this.servApp.setOcupado(true);
		}
		try {
			this.servDns.mudaStatusServ(this.servApp);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
	}
}
