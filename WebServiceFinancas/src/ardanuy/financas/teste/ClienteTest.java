package ardanuy.financas.teste;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Assert;
import org.junit.Test;

import ardanuy.financas.modelo.Conta;

public class ClienteTest {
	
	private Client client;
	private WebTarget target;
	
	public void SetupClient(){
		client = ClientBuilder.newClient();
		target = client.target("http://localhost:8080");
	}
	
	@Test
	public void testaQueServidorEstaUp(){
		SetupClient();
		String path = "/WebServiceFinancas/financas";
		String conteudo = target.path(path).request().get(String.class);
		
		Assert.assertTrue(conteudo.contains("Hello Jersey"));
	}
	
	@Test
	public void testaQueBuscaUmaConta(){
		SetupClient();
		String path = "/WebServiceFinancas/financas/conta/23";
		Conta conta = target.path(path).request().get(Conta.class);
		
		Assert.assertEquals("Andrey", conta.getTitular());
	}

}
