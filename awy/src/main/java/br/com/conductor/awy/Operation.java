/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.conductor.awy;
import br.com.conductor.sdc.api.v1.CartaoApi;
import br.com.conductor.sdc.api.v1.ContaApi;
import br.com.conductor.sdc.api.v1.invoker.ApiClient;
import br.com.conductor.sdc.api.v1.invoker.ApiException;
import br.com.conductor.sdc.api.v1.model.Cartao;
import br.com.conductor.sdc.api.v1.model.Conta;
import br.com.conductor.sdc.api.v1.model.Extrato;
import br.com.conductor.sdc.api.v1.model.Limite;
/**
 *
 * @author abraao
 */


public class Operation
{
	public  Conta createConta(ContaApi contaApi,  String Name  ) throws ApiException 
	{
		 Conta conta = new Conta();
         conta.setNome(Name);
         conta = contaApi.createUsingPOST1(conta);
		
         return conta;
	}
	
	public  Cartao createCartao(CartaoApi cartaoApi ,Conta conta1 , Configuration configuration,Client client) throws ApiException 
	{
		Cartao cartao = new Cartao();
        cartao = configuration.getConfigurationCartao(client.getCartaoName(),client.getPassword(),client.getCvv());
        cartao = cartaoApi.createUsingPOST(conta1.getId(), cartao);
		
         return cartao;
	}
	
	
	
	public void deposit( CartaoApi cartaoApi, ApiClient api, Conta conta, Cartao cartao, Double value ) throws ApiException
	{
		//ApiClient api = configuration.getConfigurationApi("ABzsplmHXjTh", "5wPpa2TyGLsq");
		 cartaoApi = new CartaoApi(api);
		 /**
	     * Creditando R$ VALOR no cartao1 
	     */
		 cartaoApi.creditarUsingPUT(conta.getId(), cartao.getId(), value);
		
	}
	
	public void transition( CartaoApi cartaoApi, ApiClient api, Conta conta1, Cartao cartao1, Double value) throws ApiException
	{
		//ApiClient api = configuration.getConfigurationApi("ABzsplmHXjTh", "5wPpa2TyGLsq");
		 cartaoApi = new CartaoApi(api);
		 /**
	     * Creditando R$ VALOR no cartao1 
	     */
		 cartaoApi.transacionarUsingPUT(conta1.getId(), cartao1.getId(), value);
		
	}
	
	public Limite limite(CartaoApi cartaoApi,Conta conta, Cartao cartao) throws ApiException
	{
		
		return cartaoApi.limiteUsingGET(conta.getId(), cartao.getId());
		
	}
	
	public Extrato extrato(CartaoApi cartaoApi,Conta conta, Cartao cartao) throws ApiException
	{
		Extrato extrato = cartaoApi.extratosUsingPOST(conta.getId(), cartao.getId()).get(0);
		return extrato;
	}
}