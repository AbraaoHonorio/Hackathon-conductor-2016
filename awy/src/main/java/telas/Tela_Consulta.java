package telas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.conducto.awy.myClient;
import br.com.conductor.sdc.api.v1.invoker.ApiException;
import br.com.conductor.sdc.api.v1.model.Extrato;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Tela_Consulta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	
	private myClient client;
	
	   public myClient getClient() {
			return client;
		}

		public void setClient(myClient client) {
			this.client = client;
			System.out.println(client.getCartaoNome());
			
		}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Consulta frame3 = new Tela_Consulta(new myClient());
					frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_Consulta(myClient client) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdClient = new JLabel("Conta: ");
		lblIdClient.setForeground(Color.WHITE);
		lblIdClient.setBounds(12, 42, 70, 15);
		contentPane.add(lblIdClient);
		
		textField = new JTextField();
		textField.setBounds(100, 40, 315, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblConsulta = new JLabel("Consulta");
		lblConsulta.setForeground(Color.WHITE);
		lblConsulta.setBounds(12, 12, 438, 19);
		contentPane.add(lblConsulta);
		
		JButton btnNewButton = new JButton("Search");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				if (source instanceof JButton){
					
					String txt = textField.getText().toString(); 
					if(txt.equals(client.getContaNome())){
						String itxt = "Cartão: "+client.getContaNome()+"\n"+"Nome: "+client.getCartaoNome();
						 
						 List<Extrato> extratos = null;
						try {
							  extratos = client.getCartaoApi().extratosUsingPOST(client.getConta().getId(), client.getCartao().getId());
							    for(Extrato e1 : extratos){
							    	itxt +=e1;
							    	System.out.println(itxt);
							    }
						} catch (ApiException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
						//txt += " "+extrato;
						JOptionPane.showMessageDialog(null, itxt);	
					} 
					else{
						JOptionPane.showMessageDialog(null, "Conta não encontrada");
						}
				}
			}
		});
		btnNewButton.setBounds(324, 71, 91, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image/teste3.png"));
		lblNewLabel.setBounds(0, -21, 450, 163);
		contentPane.add(lblNewLabel);
		
		
			
	}
}
