import java.util.LinkedList;

public class ControleServicos {

	private LinkedList<ServidorApp> media, maior, menor, primos;

	public ControleServicos() {
		this.media = new LinkedList<ServidorApp>();// 0
		this.maior = new LinkedList<ServidorApp>();// 1
		this.menor = new LinkedList<ServidorApp>();// 2
		this.primos = new LinkedList<ServidorApp>();// 3
	}

	public void addServicos(ServidorApp servApp) {
		for (Object tipoServico : servApp.getServicos()) {
			switch ((int) tipoServico) {
			case 0:// media
				media.add(servApp);
				break;
			case 1:// maior
				maior.add(servApp);
				break;
			case 2:// menor
				menor.add(servApp);
				break;
			case 3:// primos
				primos.add(servApp);
				break;
			}
		}
	}

	public ServidorApp buscaServico(int tipo) {
		switch (tipo) {
		case 0:// media
			if (media.size() > 0)
				return media.get(0);
			break;
		case 1:// maior
			if (maior.size() > 0)
				return maior.get(0);
			break;
		case 2:// menor
			if (menor.size() > 0)
				return menor.get(0);
			break;
		case 3:// primos
			if (primos.size() > 0)
				return primos.get(0);
			break;
		}
		return null;
	}
}
