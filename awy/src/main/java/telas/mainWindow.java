package telas;

import java.awt.EventQueue;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.conducto.awy.myClient;

import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.io.File;
//import java.awt.image.BufferedImage;
//import java.io.File;
import java.io.IOException;

import javax.swing.UIManager;

public class mainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public myClient client = new myClient();
	
   public myClient getClient()
   {
		return client;
	}

	public void setClient(myClient cliente) 
	{
		
		this.client = cliente;
		System.out.println(this.client.getCartaoNome());
	}

		Tela_Cadastro f;
		Tela_Consulta C;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					mainWindow frame = new mainWindow(); 
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public mainWindow() throws IOException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNew = new JButton("New Card");
		
		ImageIcon iconeNew = loadImage("image/icone.jpg");
		ImageIcon iconeNew2 = loadImage("image/icone2.jpg");
		
		btnNew.setIcon(iconeNew);
 
			
			btnNew.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            f = new Tela_Cadastro(client);
		    f.setVisible(true);
		    f.setResizable(false);}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {
            	btnNew.setIcon(iconeNew2);
            }
            public void mouseExited(MouseEvent e) {
            	btnNew.setIcon(iconeNew);
            }
        });
		
		
		btnNew.setBounds(23, 12, 174, 186);
		contentPane.add(btnNew);
		
		
		
		
		btnNew.setIcon(iconeNew);
		ImageIcon iconeConsult = loadImage("image/icone3.png");
		ImageIcon iconeConsult2 = loadImage("image/icone4.png");
		JButton btnConsult = new JButton("Consult");
		btnConsult.setBackground(UIManager.getColor("windowBorder"));
		btnConsult.setBounds(193, 12, 174, 186);
		contentPane.add(btnConsult);
		btnConsult.setIcon(iconeConsult);
		btnConsult.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            	///alClient.add(client);
            	Tela_Consulta E = new Tela_Consulta(client);
    		    E.setVisible(true);
    		    E.setResizable(false);
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {
            	btnConsult.setIcon(iconeConsult2);
            }
            public void mouseExited(MouseEvent e) {
            	btnConsult.setIcon(iconeConsult);
            }
        });
		
		//chama(client,btnConsult);
		JButton btEdit = new JButton("Edit");
		btEdit.setBackground(UIManager.getColor("Button.background"));
		btEdit.setBounds(363, 12, 174, 186);
		contentPane.add(btEdit);
		
		ImageIcon iconeEdit = loadImage("image/icone5.png");
		ImageIcon iconeEdit2 = loadImage("image/icone6.png");
		btEdit.setIcon(iconeEdit);
		
		btEdit.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
            	Tela_OP E = new Tela_OP(client);
    		    E.setVisible(true);
    		    E.setResizable(false);
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {
            	btEdit.setIcon(iconeEdit2);
            }
            public void mouseExited(MouseEvent e) {
            	btEdit.setIcon(iconeEdit);
            }
        });
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image/teste.png"));
		lblNewLabel.setBounds(0, -32, 562, 376);
		contentPane.add(lblNewLabel);
	}
	
	public ImageIcon loadImage(String urlImage) throws IOException
	{
		File mFileImage = new File(urlImage);
		BufferedImage imagem = ImageIO.read(mFileImage);
		ImageIcon image = new ImageIcon(imagem);
		return image;
	}
	
	

}

	