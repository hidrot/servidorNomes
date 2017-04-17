import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ServidorApp implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ip;
	private int porta;
	private ArrayList servicos;

	public ServidorApp(int porta, ArrayList servicos) {
		this.porta = porta;
		try {
			this.ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		this.servicos = servicos;
	}

	public String getEndereco() {
		return this.ip + ":" + this.porta;
	}

	public ArrayList getServicos() {
		return this.servicos;
	}

}