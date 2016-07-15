package br.com.conducto.awy;

import br.com.conductor.sdc.api.v1.CartaoApi;
import br.com.conductor.sdc.api.v1.model.Cartao;
import br.com.conductor.sdc.api.v1.model.Conta;

public class myClient
{

	private String nomeConta;
	private String cartaoNome;
	private String cvv;
	private Conta conta;
	private Cartao cartao;
	private CartaoApi cartaoApi;
	public String getCartaoNome() {
		return cartaoNome;
	}
	
	public void setCartaoNome(String cartaoNome) {
		this.cartaoNome = cartaoNome;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	private String senha;
	
	public String getContaNome() {
		return nomeConta;
	}
	
	public void setContaNome(String conta) {
		this.nomeConta = conta;
	}
	
	
	
	public Cartao getCartao() {
		return cartao;
	}
	
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public CartaoApi getCartaoApi() {
		return cartaoApi;
	}

	public void setCartaoApi(CartaoApi cartaoApi) {
		this.cartaoApi = cartaoApi;
	}
	
	
	
}


