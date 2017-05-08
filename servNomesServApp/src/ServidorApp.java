import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ServidorApp implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ip;
	private int porta;
	private ArrayList<Integer> servicos;
	private volatile boolean ocupado;

	public ServidorApp(int porta) {
		this.porta = porta;
		try {
			this.ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		this.ocupado = false;
	}

	public String getEndereco() {
		return this.ip + ":" + this.porta;
	}

	public ArrayList<Integer> getServicos() {
		return this.servicos;
	}

	public void setServicos(ArrayList<Integer> servicos) {
		this.servicos = servicos;

	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

}