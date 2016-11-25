import java.awt.Color;
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
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class JanelaPrincipal implements ActionListener{
	
	JFrame frameLogin = new JFrame("Autenticação");
	JPanel panelLogin = new JPanel();
	
	
	/// janela login
	Object objeto = null;
	JLabel login = new JLabel("Login:");
	JLabel senha1 = new JLabel("Senha:");
	JLabel label1 = new JLabel("Autenticação");
	
	JButton cancel = new JButton("Cancelar");
	JButton aut = new JButton("Autenticar");
	
	JTextField log = new JTextField();
	JPasswordField pass = new JPasswordField();
	Font fonte1 = new Font("Kristen ITC",0,18);
	Font fonteBox = new Font("Bookman Old Style",0,15);
	
	Image imgLock = Toolkit.getDefaultToolkit().getImage(getClass().getResource("sec.png"));
	
	Statement stm3 = null;
	ResultSet index3;
	
	 String url = "jdbc:postgresql://localhost:5432/geracaovida_alunos";  
     String usuario = "postgres";  
     String senha = "admin0123"; 
     Connection con=null;
	
	////
	
	JFrame frame = new JFrame("Cadastro de Alunos da Geração Vida v1.1");
	JPanel painel = new JPanel();
	
	ImageIcon iconeGV = new ImageIcon(getClass().getResource("Logo_Gv.png"));
	ImageIcon lupa = new ImageIcon(getClass().getResource("lupa.png"));
	ImageIcon form = new ImageIcon(getClass().getResource("Form.png"));
	Image imgGv = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo_Gv.png"));
	
	JButton botaoCadastrar = new JButton("Cadastrar novo(a) aluno(a)",form);
	JButton botaoConsultar = new JButton("Realizar nova consulta      ",lupa);
	
	JLabel label = new JLabel(iconeGV);
	JLabel alunos = new JLabel(" Alunos");
	
	Font fonte = new Font("Kristen ITC",0,50);
	
	JMenuBar menubar = new JMenuBar();
	JMenu menu = new JMenu("Menu");
	JMenuItem criaUser = new JMenuItem("Criar novo usuário");
	JMenuItem removeUser = new JMenuItem("Remover usuário");
	JMenuItem alteraSenha = new JMenuItem("Alterar senha");
		
	public JanelaPrincipal(){
			
		painel.setLayout(null);
		
		frame.setJMenuBar(menubar);
		
		menubar.add(menu);
		menu.add(criaUser);
		menu.add(removeUser);
		menu.add(alteraSenha);
		
		
		
		botaoCadastrar.setSize(300,50);
		botaoCadastrar.setLocation(750,385);
		botaoConsultar.setSize(300,50);
		botaoConsultar.setLocation(750,315);
		
		label.setSize(500, 500);
		label.setLocation(150, 100);
		
		alunos.setFont(fonte);
		alunos.setLocation(590,70);
		alunos.setSize(320, 60);
		
		
		
		painel.add(alunos);
		painel.add(label);
		painel.add(botaoConsultar);
		painel.add(botaoCadastrar);			
		botaoCadastrar.addActionListener(this);
		botaoConsultar.addActionListener(this);
		alteraSenha.addActionListener(this);
		removeUser.addActionListener(this);
		criaUser.addActionListener(this);
		aut.addActionListener(this);
		cancel.addActionListener(this);
		
		
		frame.add(painel);
		frame.setIconImage(imgGv);
		frame.setSize(1266,718);
		frame.setLocation(30,5);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

	public void janelaLogin(Object obj){
		//String password, user;
		
		objeto = obj;
		
		frameLogin.setSize(360,200);
		frameLogin.setLocation(450,250);
		frameLogin.setResizable(false);
		frameLogin.setIconImage(imgLock);
		
		panelLogin.setLayout(null);
		
		label1.setFont(new Font("Kristen ITC",0,17));
		label1.setLocation(120,10);
		label1.setSize(120,25);
		
		log.setFont(fonteBox);
		pass.setFont(fonteBox);
		
		login.setFont(fonte1);
		login.setSize(60,25);
		login.setLocation(30,45);
		log.setLocation(100, 41);
		log.setSize(170,28);
		log.setFont(fonteBox);
		
		
		senha1.setFont(fonte1);
		senha1.setSize(65, 25);
		senha1.setLocation(30, 80);
		pass.setLocation(100, 80);
		pass.setSize(170,28);
		pass.setFont(fonteBox);
				
		aut.setLocation(75, 120);
		aut.setSize(100, 35);
		cancel.setLocation(175, 120);
		cancel.setSize(100, 35);
		
		log.setText("");
		pass.setText("");
		
		
		
		panelLogin.add(cancel);
		panelLogin.add(aut);
		panelLogin.add(login);
		panelLogin.add(senha1);
		panelLogin.add(log);
		panelLogin.add(label1);
		panelLogin.add(pass);
		frameLogin.add(panelLogin);
		frameLogin.setVisible(true);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String s;
		
		if(e.getSource()==botaoCadastrar){
			new JanelaCadastro(imgGv);
		}
		if(e.getSource()==botaoConsultar){
			new JanelaConsulta(imgGv);
			
		}
		
		if(e.getSource() == criaUser){
			janelaLogin(criaUser);
		}
		if(e.getSource() == removeUser){
			janelaLogin(removeUser);
		}
		if(e.getSource() == alteraSenha){
			janelaLogin(alteraSenha);
		}
		
		if(e.getSource() == aut){
			
			if((log.getText().equals(""))||(pass.getText().equals(""))){
				JOptionPane.showMessageDialog(null, "Campos em branco");
				
			}
			else{
					try {
								try{  
					                Class.forName("org.postgresql.Driver"); 
					                con = DriverManager.getConnection(url, usuario, senha);    
					                stm3 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
					
					            }  
					            catch(SQLException a){    
					                  a.printStackTrace();  
					                  JOptionPane.showMessageDialog(null, "Problemas de conexão com o banco de dados");  
					            }   
					            catch(ClassNotFoundException a){  
					                a.printStackTrace();  
					                JOptionPane.showMessageDialog(null, "Problemas de conexão com o banco de dados"); 
					            }
								
								index3 = stm3.executeQuery("SELECT * FROM usuario WHERE login = '"+log.getText()+"';");
								if(index3.next() == false)
									JOptionPane.showMessageDialog(frameLogin, "Login ou senha inválidos", "Erro", 0);
								else{
									s = index3.getString(2);
									if(!pass.getText().equals(s)){
										JOptionPane.showMessageDialog(frameLogin, "Login ou senha inválidos", "Erro", 0);
									}
									else{
										
										if(objeto == criaUser){
											new JanelaAdicionaUsuario();
											frameLogin.dispose();
										}
											
											
										if(objeto == removeUser){
											new JanelaRemoveUsuario();
											frameLogin.dispose();
										}
										if(objeto ==  alteraSenha){
											new JanelaAlterarSenha();
											frameLogin.dispose();
										}
									}
								}						
						} 
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					
					
			}
			
		}
		
		if(e.getSource() == cancel){
			frameLogin.dispose();
		}
				
	}

}
