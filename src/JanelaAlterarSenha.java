import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class JanelaAlterarSenha implements ActionListener, MouseListener{
	
	String url = "jdbc:postgresql://localhost:5432/geracaovida_alunos";  
    String usuario = "postgres";  
    String senha = "admin0123"; 
    Connection con=null;  
    Statement stm=null;
    Statement stm2=null;
    ResultSet index;
    ResultSet index2;
    
    JFrame frame = new JFrame("Alterar senha");
    JPanel painel = new JPanel();
    
    JButton can = new JButton("Cancelar");
   
    
    ImageIcon icone = new ImageIcon(getClass().getResource("sec2.png"));
    Image imgAdd = Toolkit.getDefaultToolkit().getImage(getClass().getResource("sec2.png"));
    
    JLabel label = new JLabel(icone);
   
    DefaultListModel model1 = new DefaultListModel();
    JList list = new JList(model1);
    DefaultListModel model = (DefaultListModel) list.getModel();
    JScrollPane sp = new JScrollPane(list);
    
    /////////////////////////////
    
    JFrame frameAlt = new JFrame("Alterar senha");
	JPanel painelAlt = new JPanel();
	
	
	JLabel senhaAtu = new JLabel("Senha atual:");
	JLabel senhaNov = new JLabel("Nova senha:");
	JLabel senhaNov2 = new JLabel("Nova senha:*");
	
	
	JPasswordField senhaAtual = new JPasswordField();
	JPasswordField senhaNova = new JPasswordField();
	JPasswordField senhaNova2 = new JPasswordField();
	
	 JButton botaoAlt = new JButton("Ok");
	 
    /////////////////////////////
	
	public JanelaAlterarSenha() {
		
		frame.setLocation(450, 100);
		frame.setSize(330, 350);
		frame.setResizable(false);
		frame.setIconImage(imgAdd);
		painel.setLayout(null);
		
		label.setSize(90, 90);
		label.setLocation(130, 20);
		
		
		can.setSize(100,30);
		can.setLocation(110, 270);
		
		sp.setLocation(20, 125);
		sp.setSize(285, 130);
		
		try {  
		    
	          	try{  
	                Class.forName("org.postgresql.Driver"); 
	                con = DriverManager.getConnection(url, usuario, senha);    
	                stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	                stm2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);				
	            }  
	            catch(SQLException a){    
	                  a.printStackTrace();  
	                  JOptionPane.showMessageDialog(null, "Problemas de conexão com o banco de dados");  
	            }   
	            catch(ClassNotFoundException a){  
	                a.printStackTrace();  
	                JOptionPane.showMessageDialog(null, "Problemas de conexão com o banco de dados"); 
	            }
	          	index = stm.executeQuery("SELECT login FROM usuario order by login;");
	          	
	          	while(index.next()){
	          		model.add(model.getSize(), index.getString(1));	
	          	}
             
        }

		catch (Exception a) {     
	       a.printStackTrace();  
	    }
		
		painel.add(sp);
		painel.add(can);
		painel.add(label);
		frame.add(painel);
	
		list.addMouseListener(this);
		can.addActionListener(this);
		botaoAlt.addActionListener(this);
		
		frame.setVisible(true);
	}
		
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String aux,aux2;
		if(e.getSource() == can){
			frame.dispose();
		}
		
		if(e.getSource() == botaoAlt){
			
			if(!((senhaAtual.getText().equals(""))||(senhaNova.getText().equals(""))||(senhaNova2.getText().equals("")))){
						aux = (String)list.getSelectedValue();
						try {
							index2 = stm2.executeQuery("SELECT senha FROM usuario where login = '"+aux+"'");
							index2.next();
							
							aux2 = index2.getString(1);
							if(aux2.equals(senhaAtual.getText())){
								
									aux2 = senhaNova.getText();
									
									if(aux2.equals(senhaNova2.getText())){
										
										stm2.execute("UPDATE usuario SET senha = '"+senhaNova2.getText()+"' WHERE login = '"+aux+"'");
										JOptionPane.showMessageDialog(frame, "Senha alterada com sucesso");
										frameAlt.dispose();
										
										
									}
									else{
										JOptionPane.showMessageDialog(frame, "Senhas não correspondem!","Mensagem",0);
									}
							}
							else{
								JOptionPane.showMessageDialog(frame, "Senha antiga não corresponde!","Mensagem",0);
							}
						}
						
						catch (SQLException e1) {
							e1.printStackTrace();
						}
			}
			
			else{
				JOptionPane.showMessageDialog(frame, "Preencha todos os campos!","Aviso",0);
			}
		}
							
	}



	public void janelinhaAltSenha() {
		
		painelAlt.setLayout(null);
		
		frameAlt.setLocation(450, 150);
		frameAlt.setSize(300, 180);
		frameAlt.setIconImage(imgAdd);
		
		botaoAlt.setSize(60, 25);
		botaoAlt.setLocation(115, 110);
		
		senhaAtu.setLocation(10, 10);
		senhaAtu.setSize(100,40);
		senhaAtu.setFont(new Font("Kristen ITC",0,15));
		
		senhaAtual.setLocation(110, 20);
		senhaAtual.setSize(150,25);
				
		senhaNov.setLocation(10, 40);
		senhaNov.setSize(100,40);
		senhaNov.setFont(new Font("Kristen ITC",0,15));
		
		senhaNova.setLocation(110, 50);
		senhaNova.setSize(150,25);
		
		senhaNov2.setLocation(10, 70);
		senhaNov2.setSize(100,40);
		senhaNov2.setFont(new Font("Kristen ITC",0,15));
		
		senhaNova2.setLocation(110, 80);
		senhaNova2.setSize(150,25);
		
		senhaAtual.setText("");
		senhaNova.setText("");
		senhaNova2.setText("");
		
		painelAlt.add(senhaNova);
		painelAlt.add(senhaNova2);
		painelAlt.add(senhaAtual);
		painelAlt.add(senhaNov);
		painelAlt.add(senhaNov2);
		painelAlt.add(senhaAtu);
		painelAlt.add(botaoAlt);
		frameAlt.add(painelAlt);
		frameAlt.setVisible(true);
		
	}



	
	
	@Override
	public void mouseClicked(MouseEvent m) {
		if(m.getClickCount() == 2){
			janelinhaAltSenha();
		}
		
	}



	@Override
	public void mouseEntered(MouseEvent m) {
		
		
	}



	@Override
	public void mouseExited(MouseEvent m) {
		
		
	}



	@Override
	public void mousePressed(MouseEvent m) {
		
		
	}



	@Override
	public void mouseReleased(MouseEvent m) {
		
		
	}
	

}
