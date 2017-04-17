import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class MainCli {
	public static void main(String[] args) {
		try {
			MsgServDNS servDns = (MsgServDNS) Naming.lookup("rmi://172.16.147.77:9898/ServDNS");
			int tipoServico = 3;
			String enderecoServico = servDns.pegaEndereco(tipoServico);
			if (enderecoServico != null) {
				MsgServicos servServico = (MsgServicos) Naming.lookup("rmi://" + enderecoServico + "/ServApps");
				RespostaServicos resp = null;
				switch (tipoServico) {
				case 0:// media
				{
					ArrayList<Double> valores = new ArrayList<Double>();
					valores.add(5.0);
					valores.add(7.0);
					resp = servServico.media(valores);
				}
					break;
				case 1:// maior
				{
					ArrayList<Double> valores = new ArrayList<Double>();
					valores.add(3.0);
					valores.add(8.0);
					resp = servServico.maior(valores);
				}
					break;
				case 2:// menor
				{
					ArrayList<Double> valores = new ArrayList<Double>();
					valores.add(3.0);
					valores.add(8.0);
					resp = servServico.menor(valores);
				}
					break;
				case 3:// primos
				{
					ArrayList<Integer> valores = new ArrayList<Integer>();
					valores.add(3);
					valores.add(8);
					valores.add(2);
					valores.add(7);
					valores.add(9);
					valores.add(13);
					resp = servServico.primos(valores);
				}
					break;
				}
				System.out.println("Status: " + resp.getStatus() + "\nResultado Servico: " + resp.getResultado());
			} else {
				System.out.println("Não há um Servidor com o Serviço Requisitado");
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}
