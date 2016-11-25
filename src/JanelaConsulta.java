import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class JanelaConsulta implements ActionListener, MouseListener{
	
	
	JFrame frame = new JFrame("Nova Consulta");
	JPanel painel = new JPanel();
	JLabel nome = new JLabel("Nome:");
	
	JTextField boxNome = new JTextField();
	
	Font fonte = new Font("Kristen ITC",0,18);
	Font fonteBox = new Font("Bookman Old Style",0,15);
	
	JButton buscar = new JButton("Buscar");
	JButton listar = new JButton("Listar todos");
	
	ButtonGroup group = new ButtonGroup();
	JRadioButton rb = new JRadioButton("Nome do Aluno");
	JRadioButton rb2 = new JRadioButton("Nome do Pai");
	JRadioButton rb3 = new JRadioButton("Nome da Mãe");
	JRadioButton rb4 = new JRadioButton("Turma");
	
	String [] colunas = {"Nome do Aluno", "Idade", "Turma","Id","Nome do Pai","Nome do Mãe"};
	//String [][] dados;
	
	

	DefaultTableModel modelo = new DefaultTableModel(colunas, 0){
			public boolean isCellEditable(int rowIndex, int mColIndex){   
				return false;   
			}   
	};  
	JTable table = new JTable(modelo);
	JScrollPane sp = new JScrollPane(table);
		
	

	public JanelaConsulta(Image imgGv) {
		frame.setLocation(30,5);
		frame.setSize(1036, 418);
		frame.setResizable(false);
		frame.setIconImage(imgGv);
		
		painel.setLayout(null);
		
		nome.setFont(fonte);
		nome.setLocation(10, 10);
		nome.setSize(60, 30);
		boxNome.setLocation(70,10);
		boxNome.setSize(350,30);
		boxNome.setFont(fonteBox);
		
		buscar.setSize(150, 35);
		buscar.setLocation(430, 8);
		listar.setSize(150,35);
		listar.setLocation(590, 8);
		
		sp.setLocation(10, 90);
		sp.setSize(1005,280);
		
				
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(modelo);		
		setComprimentoColunas();
		
				
		rb.setSelected(true);
		rb.setLocation(10, 50);
		rb.setSize(120, 30);
		rb2.setLocation(130, 50);
		rb2.setSize(120, 30);
		rb3.setLocation(240, 50);
		rb3.setSize(120, 30);
		rb4.setSize(120, 30);
		rb4.setLocation(355, 50);
		group.add(rb);
		group.add(rb2);
		group.add(rb3);
		group.add(rb4);		
		
		table.addMouseListener(this);  
		buscar.addActionListener(this);
		listar.addActionListener(this);
		painel.add(buscar);
		painel.add(listar);
		painel.add(rb);
		painel.add(rb2);
		painel.add(rb3);
		painel.add(rb4);
		painel.add(sp);
		painel.add(nome);
		painel.add(boxNome);
		frame.add(painel);
		
		
		frame.setVisible(true);
				
		
	}
	
	public void setComprimentoColunas(){
		int i;
		for(i=0;i<=5;i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(200);
		}
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		
	}
	
	
	
	public Connection dataBaseSearch(Object obj){
		int i;
		
		
			try {  
			    
	            String url = "jdbc:postgresql://localhost:5432/geracaovida_alunos";  
	            String usuario = "postgres";  
	            String senha = "admin0123"; 
	            Connection con=null;  
	            Statement stm=null;
	            Statement stm2 = null;
	            ResultSet index;
	            ResultSet index2;
				Object[] result = new Object[41];
						
	            
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
	            
				if(obj==rb){
						if(boxNome.getText().equals("")){
							JOptionPane.showMessageDialog(frame, "Digite um nome!", "Erro", 2);
						}
						else{
								modelo.getDataVector().removeAllElements();
								index = stm.executeQuery("SELECT * from crianca where nome like '"+boxNome.getText().toLowerCase()+"%' order by nome;");
								if(index.next()==false){
									JOptionPane.showMessageDialog(frame, "Nenhuma Correspondência encontrada!", "Erro", 2);
									index.beforeFirst();								
								}
								else{
									index.beforeFirst();
									while(index.next()){		            			            	 
										for(i=0;i<=13;i++){
											result[i] = index.getString(i+1);
										}
										index2 = stm2.executeQuery("SELECT * from pais where id="+result[1]+";");
										index2.next();
										for(i=14;i<=40;i++){
											result[i] = index2.getString(i-13);
										}
									
										modelo.addRow(new String[]{(String) result[0],(String) result[2],(String) result[3],(String) result[1],(String) result[14],(String) result[26]});
										
									}
								}	
						}													
				}
				
				
				
				if(obj==rb2){
						if(boxNome.getText().equals("")){
							JOptionPane.showMessageDialog(frame, "Digite um nome!", "Erro", 2);
						}
						else{
							modelo.getDataVector().removeAllElements();

							index2 = stm2.executeQuery("SELECT * from pais where nome_pai like '"+boxNome.getText().toLowerCase()+"%';");
							if(index2.next()==false){
									JOptionPane.showMessageDialog(frame, "Nenhuma Correspondência encontrada!", "Erro", 2);
									index2.beforeFirst();
							}
							else{
								index2.beforeFirst();
								while(index2.next()){
									for(i=14;i<=40;i++){
										result[i] = index2.getString(i-13);
									}
									index = stm.executeQuery("SELECT * from crianca where id="+result[38]+";");
									index.next();
									for(i=0;i<=13;i++){
										result[i] = index.getString(i+1);
									}
									modelo.addRow(new String[]{(String) result[0],(String) result[2],(String) result[3],(String) result[1],(String) result[14],(String) result[26]});}

							}
							
						}
				}

		           
				
				
				
				if(obj==rb3){
							if(boxNome.getText().equals("")){
								JOptionPane.showMessageDialog(frame, "Digite um nome!", "Erro", 2);
							}
							else{
									modelo.getDataVector().removeAllElements();
				
									index2 = stm2.executeQuery("SELECT * from pais where nome_mae like '"+boxNome.getText().toLowerCase()+"%';");
									if(index2.next()==false){
												JOptionPane.showMessageDialog(frame, "Nenhuma Correspondência encontrada!", "Erro", 2);
												index2.beforeFirst();
									}
									else{
											index2.beforeFirst();
											while(index2.next()){
												 for(i=14;i<=40;i++){
						            				result[i] = index2.getString(i-13);
						            			 }
						            			 index = stm.executeQuery("SELECT * from crianca where id="+result[38]+";");
						            			 index.next();
						            			 for(i=0;i<=13;i++){
						            				result[i] = index.getString(i+1);
						           				 }
						            			 modelo.addRow(new String[]{(String) result[0],(String) result[2],(String) result[3],(String) result[1],(String) result[14],(String) result[26]});}

									}
							}
				}
				
				
				if(obj==rb4){
					if(boxNome.getText().equals("")){
						JOptionPane.showMessageDialog(frame, "Digite um nome!", "Erro", 2);
					}
					else{
							modelo.getDataVector().removeAllElements();
							index = stm.executeQuery("SELECT * from crianca where turma like '"+boxNome.getText().toLowerCase()+"%' order by nome;");
							if(index.next()==false){
								JOptionPane.showMessageDialog(frame, "Nenhuma Correspondência encontrada!", "Erro", 2);
								index.beforeFirst();								
							}
							else{
								index.beforeFirst();
								while(index.next()){		            			            	 
									for(i=0;i<=13;i++){
										result[i] = index.getString(i+1);
									}
									index2 = stm2.executeQuery("SELECT * from pais where id="+result[1]+";");
									index2.next();
									for(i=14;i<=40;i++){
										result[i] = index2.getString(i-13);
									}
								
									modelo.addRow(new String[]{(String) result[0],(String) result[2],(String) result[3],(String) result[1],(String) result[14],(String) result[26]});
									
								}
							}	
					}													
			}
				
				
				if(obj==listar){
					modelo.getDataVector().removeAllElements();
					index = stm.executeQuery("SELECT * from crianca order by nome;");
					if(index.next()==false){
						JOptionPane.showMessageDialog(frame, "Nenhum Registro encontrado!", "Erro", 2);
						index.beforeFirst();								
					}
					else{
						index.beforeFirst();
						while(index.next()){		            			            	 
							for(i=0;i<=13;i++){
								result[i] = index.getString(i+1);
							}
							index2 = stm2.executeQuery("SELECT * from pais where id="+result[1]+";");
							index2.next();
							for(i=14;i<=40;i++){
								result[i] = index2.getString(i-13);
							}
							
							modelo.addRow(new String[]{(String) result[0],(String) result[2],(String) result[3],(String) result[1],(String) result[14],(String) result[26]});
						}
					}
					
				}
				
		        con.close();  
	               
	        } 
			catch (Exception a) {     
	           a.printStackTrace();  
	        }
			
		
		return null;
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==buscar){
			if(rb.isSelected()==true)
				dataBaseSearch(rb);
			
			if(rb2.isSelected()==true)
				dataBaseSearch(rb2);
			
			if(rb3.isSelected()==true)
				dataBaseSearch(rb3);
			if(rb4.isSelected()==true)
				dataBaseSearch(rb4);
		}
		if(e.getSource()==listar)
			dataBaseSearch(listar);
		
		
	}

	@Override
	public void mouseClicked(MouseEvent m) {
		String nome;
		String t;
		if(m.getClickCount()==2){
			
			nome=(String) modelo.getValueAt(table.getSelectedRow(),0);
			t = (String) modelo.getValueAt(table.getSelectedRow(),3);
			new JanelaConsultaCompleta(nome,t);
			
		}
	}

	@Override
	public void mouseEntered(MouseEvent m) {
		
	}

	@Override
	public void mouseExited(MouseEvent m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent m) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseReleased(MouseEvent m) {
		// TODO Auto-generated method stub
		
	}

	
	
}
