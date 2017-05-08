public class ServidorDNS {

	private ControleServidores controleServidores;

	public ServidorDNS() {
		this.controleServidores = new ControleServidores();
	}

	public int registraServidor(ServidorApp serv) {
		return controleServidores.addServidor(serv);
	}

	public int desregistraServidor(ServidorApp serv) {
		return controleServidores.removeServidor(serv);
	}

	public String getServico(int tipo) {
		return controleServidores.getServico(tipo);
	}

	public void mudaStatusServ(ServidorApp serv) {
		controleServidores.mudaStatusServ(serv);
	}

}