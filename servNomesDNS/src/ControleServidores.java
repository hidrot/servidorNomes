import java.util.Vector;

public class ControleServidores {

	private Vector<ServidorApp> servidores;
	private ControleServicos controleServicos;

	public ControleServidores() {
		this.servidores = new Vector<ServidorApp>();
		this.controleServicos = new ControleServicos();
	}

	public int addServidor(ServidorApp servApp) {
		if (!servApp.getServicos().isEmpty()) {
			this.servidores.add(servApp);
			this.controleServicos.addServicos(servApp);
			return 0;
		} else {
			return 1;
		}
	}

	public String getServico(int tipo) {
		ServidorApp servBuscado = this.controleServicos.buscaServico(tipo);
		return servBuscado != null ? servBuscado.getEndereco() : null;
	}
}
