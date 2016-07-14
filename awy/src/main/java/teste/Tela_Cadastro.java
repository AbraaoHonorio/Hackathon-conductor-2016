package teste;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import br.com.conducto.awy.myClient;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Tela_Cadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfSenha;
	private JTextField tfCvv;
	private JTextField tfConta;
	private JLabel lblCadastro;
	private JLabel lblCvv;
	private JLabel lblConta;
	private JButton btnNewButton;
	JTextField textField_4;
	private String nome;
	private String senha;
	private String cvv;
	private String conta;
	myClient client;
	mainWindow m;
    
	
	public mainWindow getM() {
		return m;
	}

	public void setM(mainWindow m) {
		this.m = m;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Cadastro frame = new Tela_Cadastro(new myClient());
					frame.setVisible(true);
					System.out.println("i'm here");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public myClient getMyClient() 
	{
		return client;
		
	}
	public Tela_Cadastro(myClient client) {
		
		//this.client = client;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 562, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Conta");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(12, 56, 70, 15);
		contentPane.add(lblNome);
		
		JTextField textField = new JTextField();
		textField.setBounds(83, 82, 326, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setBounds(12, 111, 70, 15);
		contentPane.add(lblSenha);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(83, 111, 326, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblCadastro = new JLabel("Cadastro");
		lblCadastro.setForeground(Color.WHITE);
		lblCadastro.setBounds(12, 12, 70, 15);
		contentPane.add(lblCadastro);
		
		lblCvv = new JLabel("Cvv");
		lblCvv.setForeground(Color.WHITE);
		lblCvv.setBounds(12, 138, 70, 15);
		contentPane.add(lblCvv);
		
		JTextField textField_3 = new JTextField();
		textField_3.setBounds(84, 136, 114, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(83, 54, 326, 19);
		contentPane.add(textField_4);
		
		btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome = textField.getText();
				senha = textField_1.getText();
				cvv = textField_3.getText();
				conta = textField_4.getText();
			    //client = new myClient();
			    client.setCartaoNome(nome);
			    client.setSenha(senha);
			    client.setContaNome(conta);
			    client.setCvv(cvv);
			    Tela_Consulta c = new Tela_Consulta(client);
			    //c.setClient(client);
			    try {
					m = new mainWindow();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			   // System.out.print(client.getContaNome());
			    //m.setClient(client);
				setVisible (false); 
			}
		});
		
		
		JLabel lblConta = new JLabel("Nome");
		lblConta.setForeground(Color.WHITE);
		lblConta.setBounds(12, 84, 70, 15);
		contentPane.add(lblConta);
		btnNewButton.setBounds(12, 218, 92, 25);
		contentPane.add(btnNewButton);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image/teste.png"));
		lblNewLabel.setBounds(0, -43, 562, 343);
		contentPane.add(lblNewLabel);
	}
	
	
}