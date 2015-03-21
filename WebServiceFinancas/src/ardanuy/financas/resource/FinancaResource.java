package ardanuy.financas.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ardanuy.financas.dao.ContaDao;
import ardanuy.financas.dao.MovimentacaoDao;
import ardanuy.financas.modelo.Conta;
import ardanuy.financas.modelo.Movimentacao;
import ardanuy.financas.util.JPAUtil;

@Path("/financas")
public class FinancaResource {

	
	@GET
	@Produces
	public String sayPlainTextHello(){
		return "Hello Jersey";
	}
	
	@Path("movimentacoes/{contaId}")
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Movimentacao> buscarMovimentacoesDaConta(@PathParam("contaId") Integer contaId){
		MovimentacaoDao movimentacaoDao = new MovimentacaoDao(new JPAUtil().getEntityManager());
		
		List<Movimentacao> movimentacoes = movimentacaoDao.listaMovimentacoesPorContaId(contaId);
		
		return movimentacoes;
	} 
	
	
	@Path("conta/{contaId}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Conta buscarConta(@PathParam("contaId") Integer contaId){
		//ContaDao contaDao = new ContaDao(new JPAUtil().getEntityManager());		
		//Conta conta = contaDao.buscaContaPorId(contaId);
		
		Conta conta = new ContaDao(new JPAUtil().getEntityManager()).buscaContaPorId(contaId);
		
		return conta;
	}
	
	@Path("conta/json/{contaId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscarContaEmJson(@PathParam("contaId") Integer contaId){
		//ContaDao contaDao = new ContaDao(new JPAUtil().getEntityManager());		
		//Conta conta = contaDao.buscaContaPorId(contaId);
		
		Conta conta = new ContaDao(new JPAUtil().getEntityManager()).buscaContaPorId(contaId);		
		
		return conta.toJon();
	}
}
