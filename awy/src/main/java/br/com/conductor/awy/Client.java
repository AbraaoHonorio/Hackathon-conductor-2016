/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.conductor.awy;


/**
 *
 * @author abraao
 */
public class Client
{
        private String nameClient;
        private String cpf;     
        private String nameConta;
        private String Password;
	private String cartaoName;
	private String cvv;
        private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
             
	

  public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nomeClient) {
        this.nameClient = nomeClient;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNameConta() {
        return nameConta;
    }

    public void setNameConta(String nomeConta) {
        this.nameConta = nomeConta;
    }
       
   
	public String getCartaoName() {
		return cartaoName;
	}
	
	public void setCartaoNome(String cartaoNome) {
		this.cartaoName = cartaoNome;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}

	
	
	public String getContaName() {
		return nameConta;
	}
	
	public void setContaName(String conta) {
		this.nameConta = conta;
	}
	
	
	
}
