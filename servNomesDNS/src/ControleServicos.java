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
			default:
				break;
			}
		}
	}

	public void removeServicos(ServidorApp servApp) {
		this.media.remove(servApp);
		this.maior.remove(servApp);
		this.menor.remove(servApp);
		this.primos.remove(servApp);
	}

	public ServidorApp buscaServico(int tipo) {
		switch (tipo) {
		case 0:// media
			if (media.size() > 0)
				for (int i = 0; i < media.size(); i++) {
					if (!media.get(i).isOcupado()) {
						return media.get(i);
					}
				}
			break;
		case 1:// maior
			if (maior.size() > 0)
				for (int i = 0; i < maior.size(); i++) {
					if (!maior.get(i).isOcupado()) {
						return maior.get(i);
					}
				}
			break;
		case 2:// menor
			if (menor.size() > 0)
				for (int i = 0; i < menor.size(); i++) {
					if (!menor.get(i).isOcupado()) {
						return menor.get(i);
					}
				}
			break;
		case 3:// primos
			if (primos.size() > 0)
				for (int i = 0; i < primos.size(); i++) {
					if (!primos.get(i).isOcupado()) {
						return primos.get(i);
					}
				}
			break;
		}
		return null;
	}
}
