import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class JanelaAdicionaUsuario implements ActionListener{
	

	String url = "jdbc:postgresql://localhost:5432/geracaovida_alunos";  
    String usuario = "postgres";  
    String senha = "admin0123"; 
    Connection con=null;  
    Statement stm=null;
    ResultSet index;
	
	JFrame frame = new JFrame("Criar novo usuário");
	JPanel painel = new JPanel();
	
	JButton ok = new JButton("Concluído");
	JButton cancel = new JButton("Cancelar");
	
	JLabel usuario1 = new JLabel("Nome:");
	JLabel log = new JLabel("Login:");
	JLabel senha1 = new JLabel("Senha:");
	JLabel senha2 = new JLabel("Senha:*");
	
	ImageIcon icone = new ImageIcon(getClass().getResource("add_user.png"));
	JLabel image = new JLabel(icone);
	
	JTextField user = new JTextField();
	JTextField login = new JTextField();
	JPasswordField pass = new JPasswordField();
	JPasswordField confPass = new JPasswordField();
	
	Image imgAdd = Toolkit.getDefaultToolkit().getImage(getClass().getResource("add_user.png"));
	
	
	public JanelaAdicionaUsuario(){
		
		frame.setLocation(450, 100);
		frame.setSize(330, 350);
		frame.setResizable(false);
		frame.setIconImage(imgAdd);
		painel.setLayout(null);
		
		
		image.setSize(90, 90);
		image.setLocation(130, 20);
		
		usuario1.setFont(new Font("Kristen ITC",0,16));
		usuario1.setSize(55, 30);
		usuario1.setLocation(60, 130);
		
		user.setSize(130, 27);
		user.setLocation(120, 133);
		
		log.setFont(new Font("Kristen ITC",0,16));
		log.setSize(55, 30);
		log.setLocation(60, 160);
		
		login.setSize(130, 27);
		login.setLocation(120, 163);
		
		senha1.setFont(new Font("Kristen ITC",0,16));
		senha1.setSize(55, 30);
		senha1.setLocation(58, 190);
		
		pass.setSize(130, 27);
		pass.setLocation(120, 193);
		
		senha2.setFont(new Font("Kristen ITC",0,16));
		senha2.setSize(60, 30);
		senha2.setLocation(55, 220);
		
		confPass.setSize(130, 27);
		confPass.setLocation(120, 223);
			
		ok.setSize(100,30);
		ok.setLocation(55,270);
		cancel.setSize(100,30);
		cancel.setLocation(155, 270);
		
		
		painel.add(ok);
		painel.add(cancel);
		painel.add(usuario1);
		painel.add(log);
		painel.add(senha1);
		painel.add(senha2);
		painel.add(user);
		painel.add(login);
		painel.add(pass);
		painel.add(confPass);
		painel.add(image);
		
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
		frame.add(painel);
		frame.setVisible(true);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nome, log, senha1, senha2;
		
		if(e.getSource() == cancel){
			frame.dispose();
		}
		
		if(e.getSource() == ok){
			
			nome = user.getText();
			log = this.login.getText();
			senha1 = pass.getText();
			senha2 = confPass.getText();
			
			if((nome.equals(""))||(log.equals(""))||(senha1.equals(""))||(senha2.equals(""))){
				JOptionPane.showMessageDialog(frame, "Todos os campos são de preenchimento obrigatório","Aviso",0);
			}
			else{
					if(senha1.equals(senha2)){
						
						try {  
						    
					          	try{  
					                Class.forName("org.postgresql.Driver"); 
					                con = DriverManager.getConnection(url, usuario, senha);    
					                stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
					                					
					            }  
					            catch(SQLException a){    
					                  a.printStackTrace();  
					                  JOptionPane.showMessageDialog(null, "Problemas de conexão com o banco de dados");  
					            }   
					            catch(ClassNotFoundException a){  
					                a.printStackTrace();  
					                JOptionPane.showMessageDialog(null, "Problemas de conexão com o banco de dados"); 
					            }
								//
								index = stm.executeQuery("SELECT * FROM usuario WHERE login ='"+log+"';");
								if(index.next() == true)
									JOptionPane.showMessageDialog(frame, "Login já cadastrado");
								else{
									stm.execute("INSERT INTO usuario (nome, senha, login) VALUES ('"+nome+"','"+senha1+"','"+log+"');");
									JOptionPane.showMessageDialog(frame,"Novo usuário cadastrado com sucesso!","Cadastro realizado",1);
									frame.dispose();
								}
								
									
								
					             
					        }
					
						catch (Exception a) {     
				           a.printStackTrace();  
				        }
						
					}
					else
						JOptionPane.showMessageDialog(frame, "As senhas não correspondem", "Erro", 0);
			}
			
					
		}		
		
	}

}
