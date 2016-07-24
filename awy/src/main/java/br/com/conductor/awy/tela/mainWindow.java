/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.conductor.awy.tela;

import br.com.conductor.awy.Client;
import br.com.conductor.sdc.api.v1.invoker.ApiException;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author abraao
 */


public class mainWindow extends javax.swing.JFrame {
   extractWindow clientWindow = null;
   private String strDefault = null;
    /**
     * Creates new form mainWindow
     */
    public mainWindow() throws IOException {
        initComponents();
        setIcon();
        setVoiceCpf();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VoicePi");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(950, 500));
        setMinimumSize(new java.awt.Dimension(950, 500));
        getContentPane().setLayout(null);

        jButton2.setIcon(new javax.swing.ImageIcon("image/Extract.png")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(20, 100, 394, 268);

        jButton3.setIcon(new javax.swing.ImageIcon("image/Settings.png")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(540, 100, 394, 268);

        jLabel3.setIcon(new javax.swing.ImageIcon("image/logoConductor.png")); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(740, 420, 190, 70);

        jLabel2.setIcon(new javax.swing.ImageIcon("image/backgroundT.jpg")); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -80, 950, 690);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //System.err.println("aasdasasasasdasasdasaasd");
        // strDefault = "209.309.409-54";
        String Ccpf = String.valueOf(JOptionPane.showInputDialog("Digite seu CPF: ",strDefault));
        List<Client> listClient = new LinkedList<Client>();
        listClient = getClient();

        
       
           
            try {
               
                System.out.println(Ccpf);
                boolean validCpf = false;
                double[] values;
                values = new double[]{1950.0,2530.0,3854.0};

                for (int i = 0; i < listClient.size(); i++) {
                   if(listClient.get(i).getCpf().equals(Ccpf))
                   {
                        clientWindow = new extractWindow();
                        clientWindow.setVisible(true);
                        clientWindow.setInformation(listClient.get(i),values[i]);
                        clientWindow.setVisible(true);
                        clientWindow.setState(JFrame.NORMAL);
                        validCpf=true;
                   }
                   
                    
                }
                if(validCpf == false)
                {
                       JOptionPane.showMessageDialog(this, "CPF não consta no sistema");
                }
              
                
                
            } catch (ApiException ex) 
            {
              
                Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Support support = new Support();
        support.setLocationRelativeTo(null);
        support.setVisible(true);
       // support.setState(JFrame.NORMAL);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new mainWindow().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    private void setVoiceCpf() throws IOException 
    {
        try(BufferedReader br = new BufferedReader(new FileReader("fileVoice/file.txt"))) {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        line = br.readLine();
        }
        strDefault = sb.toString(); //trim()
      //  JOptionPane.showMessageDialog(this, strDefault);
        
}
    }
    
     private void setIcon() 
    {
            ImageIcon icon = new ImageIcon("image/atm.png");
           super.setIconImage(icon.getImage());
    }
    
    private  List<Client> getClient()
    {
        List<Client> listClient = new LinkedList<Client>();
        Client client = new Client();
        client.setCartaoNome("Cartão universitário BB");
        client.setNameClient("Abraão Állysson dos Santos Honório");
        client.setCpf("209 309 409 54 ");
	client.setPassword("11111");
	client.setContaName("Caixa");
        client.setCvv("caixa-aaa");
        client.setStatus("ATIVO");
        listClient.add(client);
        
        Client client1 = new Client();
        client1.setCartaoNome("Cartão universitário");
        client1.setNameClient("Wellton Thyago de Souza");
        client1.setCpf("444 555 666 77 ");
	client1.setPassword("22222222");
	client1.setContaName("Caixa Econômica Federal");
        client1.setCvv("bancoDoBrasil-bbb");
        client1.setStatus("BLOQUEADO");
        listClient.add(client1);
        
         Client client2 = new Client();
        client2.setCartaoNome("Cartão universitário Bradesco");
        client2.setNameClient("Yuri da Costa Gouveia");
        client2.setCpf("111 222 333 44 ");
 	client2.setPassword("333333333333");
	client2.setContaName("Bradesco");
        client2.setCvv("BancoBradesco-ccc");
        client2.setStatus("BLOQUEADO");
        
        
        return listClient;
    }
    
     

}