package telas;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.conducto.awy.Configuration;
import br.com.conducto.awy.Operation;
import br.com.conducto.awy.myClient;
import br.com.conductor.sdc.api.v1.CartaoApi;
import br.com.conductor.sdc.api.v1.ContaApi;
import br.com.conductor.sdc.api.v1.invoker.ApiClient;
import br.com.conductor.sdc.api.v1.invoker.ApiException;
import br.com.conductor.sdc.api.v1.model.Cartao;
import br.com.conductor.sdc.api.v1.model.Conta;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Tela_OP2 extends JFrame {
	 Conta conta=null;
     Cartao cartao=null;
     Configuration configuration=null;
     CartaoApi cartaoApi=null;
     ApiClient api = null;
     ContaApi contaApi =null;
	private JPanel contentPane;
	//myClient client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_OP2 frame = new Tela_OP2(new myClient());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_OP2(myClient client) {
		Operation operation = new Operation();
		 configuration = new Configuration();
		 api = configuration.getConfigurationApi("ABzsplmHXjTh", "5wPpa2TyGLsq");
		 cartaoApi = new CartaoApi(api);
	     contaApi = new ContaApi(api);
	          
	     
	      
         client.setCartaoApi(cartaoApi);
         try {
			 conta = operation.createConta(contaApi, client.getContaNome());
		} catch (ApiException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
         client.setConta(conta);
     
	try {
		cartao = operation.createCartao(cartaoApi, conta, configuration, client);
	} catch (ApiException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	     
	     
	     
	     
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 131);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	     
		JButton btnNewButton = new JButton("Creditar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valueTransition = Double.parseDouble(JOptionPane.showInputDialog("Quanto deseja creditar ?"));	
				//chame o metodo de adicionar na conta o valor de int
				
	            try {
					
					operation.transition(cartaoApi,api,conta,cartao,valueTransition);
				} catch (ApiException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(56, 12, 117, 44);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Transacionar");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valueDeposit = Double.parseDouble(JOptionPane.showInputDialog("Quanto deseja transacionar ?"));
				//chame o metodo de transacionar na conta o valor de int
				
			     
				 try {
					operation.deposit(cartaoApi, api, conta, cartao, valueDeposit);
				} catch (ApiException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 	
				  client.setCartao(cartao);
			}
		});
		btnNewButton_1.setBounds(235, 12, 117, 44);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image/teste2.png"));
		lblNewLabel.setBounds(0, -27, 450, 152);
		contentPane.add(lblNewLabel);

	}
}
