/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.conductor.awy;


import br.com.conductor.sdc.api.v1.invoker.ApiClient;
import br.com.conductor.sdc.api.v1.invoker.auth.ApiKeyAuth;
import br.com.conductor.sdc.api.v1.model.Cartao;
/**
 *
 * @author abraao
 */
public class Configuration
{
	
	
	public ApiClient getConfigurationApi(String token,String cliente)
	{
		 ApiClient api = new ApiClient();
         api.setBasePath("https://api.conductor.com.br/sdc");

         /**
          * Setando o access_token e client_id de acesso. Você pode conseguir os seus se cadastrando em http://pierlabs.io
          */
         ((ApiKeyAuth) api.getAuthentication("access_token")).setApiKey(token);
         ((ApiKeyAuth) api.getAuthentication("client_id")).setApiKey(cliente);

         
       //  System.out.println(token+" "+cliente);
		return api;
	}
	
	public  Cartao getConfigurationCartao(String nomeCartao, String senha, String cvv)
	{
		 /**
         * Criando o cartão 01 da conta 01
         */
        Cartao cartao = new Cartao();
        cartao.setNome(nomeCartao);
        cartao.setSenha(senha);
        cartao.setCvv(cvv);
        return cartao;
       // cartao1 = cartaoApi.createUsingPOST(conta1.getId(), cartao1);
	}
	
	
}
