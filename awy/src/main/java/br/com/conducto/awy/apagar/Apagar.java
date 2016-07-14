package br.com.conducto.awy.apagar;

import java.util.List;

import br.com.conductor.sdc.api.v1.CartaoApi;
import br.com.conductor.sdc.api.v1.ContaApi;
import br.com.conductor.sdc.api.v1.invoker.ApiClient;
import br.com.conductor.sdc.api.v1.invoker.auth.ApiKeyAuth;
import br.com.conductor.sdc.api.v1.model.Cartao;
import br.com.conductor.sdc.api.v1.model.Conta;
import br.com.conductor.sdc.api.v1.model.Extrato;
import br.com.conductor.sdc.api.v1.model.Limite;

public class Apagar {
	
	public static void main(String[] args) throws Exception{
		
	    /**
	     * Configurando a api
	     */
	    ApiClient api = new ApiClient();
	    api.setBasePath("https://api.conductor.com.br/sdc");

	    /**
	     * Setando o access_token e client_id de acesso. Você pode conseguir os seus se cadastrando em http://pierlabs.io
	     */
	    ((ApiKeyAuth) api.getAuthentication("access_token")).setApiKey("ABzsplmHXjTh");
	    ((ApiKeyAuth) api.getAuthentication("client_id")).setApiKey("5wPpa2TyGLsq");

	    CartaoApi cartaoApi = new CartaoApi(api);
	    ContaApi contaApi = new ContaApi(api);

	    /**
	     * Criando conta 01
	     */
	    Conta conta1 = new Conta();
	    conta1.setNome("NOME CONTA 1");
	    conta1 = contaApi.createUsingPOST1(conta1);

	    /**
	     * Criando o cartão 01 da conta 01
	     */
	    Cartao cartao1 = new Cartao();
	    cartao1.setNome("NOME DO CARTAO");
	    cartao1.setSenha("123123098asd@");
	    cartao1.setCvv("cvv");
	    cartao1 = cartaoApi.createUsingPOST(conta1.getId(), cartao1);

	    /**
	     * Creditando R$ 100.00 no cartao1 
	     */
	    cartaoApi.creditarUsingPUT(conta1.getId(), cartao1.getId(), 100.00);

	    /**
	     * Transacionando R$ 0.10 do cartao1
	     */
	    cartaoApi.transacionarUsingPUT(conta1.getId(), cartao1.getId(), 0.10);

	    /**
	     * Verificando se o limite é de 99.90
	     */
	    Limite limite = cartaoApi.limiteUsingGET(conta1.getId(), cartao1.getId());
	    System.out.println(limite);

	    /**
	     * Imprimindo os extratos. Deverá aparecer duas transações:
	     * 1ª - Credito de 100.00
	     * 2ª - Débito de 0.10
	     */
	    List<Extrato> extratos = cartaoApi.extratosUsingPOST(conta1.getId(), cartao1.getId());
	    for(Extrato e : extratos){
	    	System.out.println(e);
	    }

	    /**
	     * Criando o cartão 02 da conta 01
	     */
	    Cartao cartao2 = new Cartao();
	    cartao2.setNome("NOME DO CARTAO");
	    cartao2.setSenha("123123098asd@");
	    cartao2.setCvv("cvv");
	    cartao2 = cartaoApi.createUsingPOST(conta1.getId(), cartao2);

	    /**
	     * Consultando os cartões da conta 01. Deverá retorna dois cartões
	     */
	    cartaoApi.getAllUsingGET(conta1.getId()).stream().forEach(c -> System.out.println(c));

	    /**
	     * Transferindo 10.10 do cartão 1 para o cartão 2
	     */
	    cartaoApi.transferirUsingPOST(conta1.getId(), cartao1.getId(), cartao2.getId(), 10.10);

	    /**
	     * Verificando se o limite do cartoa 1 é de 89.80
	     */
	    limite = cartaoApi.limiteUsingGET(conta1.getId(), cartao1.getId());
	    System.out.println(limite);

	    /**
	     * Verificando o limite do cartão 2 que deverá ser de 10.10
	     */
	    limite = cartaoApi.limiteUsingGET(conta1.getId(), cartao2.getId());
	    System.out.println(limite);  
	    
	}

}
