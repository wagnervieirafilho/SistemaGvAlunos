import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

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

public class JanelaRemoveUsuario implements ActionListener, MouseListener{
	
	String url = "jdbc:postgresql://localhost:5432/geracaovida_alunos";  
    String usuario = "postgres";  
    String senha = "admin0123"; 
    Connection con=null;  
    Statement stm=null;
    Statement stm2=null;
    ResultSet index;
    ResultSet index2;
    
    JFrame frame = new JFrame("Remover usuário");
    JPanel painel = new JPanel();
    
    JButton rem = new JButton("Excluir");
    JButton can = new JButton("Cancelar");
    
    ImageIcon icone = new ImageIcon(getClass().getResource("rem_user.png"));
    Image imgAdd = Toolkit.getDefaultToolkit().getImage(getClass().getResource("rem_user.png"));
    
    JLabel label = new JLabel(icone);
   
    DefaultListModel model1 = new DefaultListModel();
    JList list = new JList(model1);
    DefaultListModel model = (DefaultListModel) list.getModel();
    JScrollPane sp = new JScrollPane(list);
    //model.add(model.getSize(), "item final");	
    	
	public JanelaRemoveUsuario(){
		frame.setLocation(450, 100);
		frame.setSize(330, 350);
		frame.setResizable(false);
		frame.setIconImage(imgAdd);
		painel.setLayout(null);
		
		label.setSize(90, 90);
		label.setLocation(130, 20);
		
		
		rem.setSize(100,30);
		rem.setLocation(55,270);
		can.setSize(100,30);
		can.setLocation(155, 270);
		
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
		painel.add(rem);
		painel.add(can);
		painel.add(label);
		frame.add(painel);
		list.addMouseListener(this);
		can.addActionListener(this);
		rem.addActionListener(this);
		frame.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String aux;
		int a;
		if(e.getSource() == can){
			frame.dispose();
		}
		
		
		if(e.getSource() == rem){
			aux = (String)list.getSelectedValue();
			try {
				
				a = JOptionPane.showConfirmDialog(frame, "Tem certeza que deseja excluir "+aux.toUpperCase()+"?");
				if(a==0){
					a = list.getSelectedIndex();
					model.remove(a);
					stm.execute("DELETE FROM usuario where login='"+aux+"'");
					JOptionPane.showMessageDialog(frame, "Usuário excluído com sucesso!", "Mensagem", 1);		
					
				}
				
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String aux;
		if(e.getClickCount() == 2){
			
			aux = (String)list.getSelectedValue();
			try {
				index2 = stm2.executeQuery("SELECT * FROM usuario WHERE login = '"+aux+"';");
				index2.next();
				aux = index2.getString(1);
				JOptionPane.showMessageDialog(frame, "Nome do usuário: \n"+aux.toUpperCase()+"");
				
			}
			catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
			
	}

	@Override
	public void mouseExited(MouseEvent e) {
			
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	
		
	}

}
