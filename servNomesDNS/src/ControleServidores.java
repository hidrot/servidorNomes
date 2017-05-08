import java.util.Vector;

public class ControleServidores {

	private Vector<ServidorApp> servidores;
	private ControleServicos controleServicos;

	public ControleServidores() {
		this.servidores = new Vector<ServidorApp>();
		this.controleServicos = new ControleServicos();
	}

	public int addServidor(ServidorApp servApp) {
		if (buscaServidor(servApp) == null) {
			if (!servApp.getServicos().isEmpty()) {
				this.servidores.add(servApp);
				this.controleServicos.addServicos(servApp);
				return 0;
			} else {
				return 1;
			}
		}
		return 2;
	}

	public int removeServidor(ServidorApp servApp) {
		ServidorApp servRemove = buscaServidor(servApp);
		if (servRemove != null) {
			servidores.remove(servRemove);
			controleServicos.removeServicos(servRemove);
			return 0;
		}
		return 1;
	}

	private ServidorApp buscaServidor(ServidorApp servApp) {
		for (int i = 0; i < servidores.size(); i++) {
			if (servidores.get(i).getEndereco().equals(servApp.getEndereco())) {
				return servidores.get(i);
			}
		}
		return null;
	}

	public String getServico(int tipo) {
		ServidorApp servBuscado = this.controleServicos.buscaServico(tipo);
		return servBuscado != null ? servBuscado.getEndereco() : null;
	}
	
	public void mudaStatusServ(ServidorApp servApp){
		ServidorApp serv = buscaServidor(servApp);
		serv.setOcupado(servApp.isOcupado());
	}
}
