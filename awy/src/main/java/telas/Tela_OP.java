package telas;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.conducto.awy.myClient;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Tela_OP extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	//private myClient client;
	private final JLabel lblNewLabel_3 = new JLabel("");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_OP frame = new Tela_OP(new myClient());
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
	public Tela_OP(myClient client) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 139);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID Cliente");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 27, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(12, 54, 70, 15);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(113, 25, 168, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(113, 52, 168, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(309, 49, 117, 25);
		btnNewButton.addMouseListener(new MouseListener() {
        public void mouseClicked(MouseEvent e) {
        	
        	//String login = textField.getText();
        	//String senha = textField_1.getText();
        	//if(login.equals(client.getContaNome()) && senha.equals(client.getSenha())){
			JFrame f = new Tela_OP2(client);
			f.setVisible(true);
			//f.setResizable(false);}
        	//else{
        		//JOptionPane.showMessageDialog(null, "Login Invalido");}
			//os comentários indicam um meio de fazer o login, basta adaptar ai
        	}
        
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}});
		contentPane.add(btnNewButton);

		
		lblNewLabel_3.setIcon(new ImageIcon("image/teste2.png"));
		lblNewLabel_3.setBounds(0, -38, 450, 189);
		contentPane.add(lblNewLabel_3);
	}

}