import java.io.Serializable;

public class RespostaServicos implements Serializable {

	private static final long serialVersionUID = 1L;
	private int status;
	private double resultado;

	public RespostaServicos(int status, double resultado) {
		this.status = status;
		this.resultado = resultado;
	}

	public int getStatus() {
		return status;
	}

	public double getResultado() {
		return resultado;
	}

}
