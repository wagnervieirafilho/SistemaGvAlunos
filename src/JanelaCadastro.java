import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.sql.*;


public class JanelaCadastro implements ActionListener, FocusListener{
	
	public static int cont=0;
	int numero;
	
	ImageIcon botaoOk = new ImageIcon(getClass().getResource("Ok.png"));
	ImageIcon botaoCancelar = new ImageIcon(getClass().getResource("cancel.png"));
	
	JFrame frame = new JFrame("Novo(a) aluno(a)");
	JPanel painel = new JPanel();
	
	JButton ok = new JButton("  Ok", botaoOk);
	JButton cancelar = new JButton("Cancelar", botaoCancelar);
	
	JLabel nomeCrianca = new JLabel("Nome:");
	JLabel idade = new JLabel("Idade:");
	JLabel turma = new JLabel("Turma:");
	JLabel dataNascimento = new JLabel("Data de Nascimento:");
	JLabel alergicoAlimentos = new JLabel("Alérgico a algum alimento?");
	JLabel alergicoAlimentos2 = new JLabel("Qual?");
	JLabel possuiIrmaos = new JLabel("Possui irmãos?");
	
	JLabel nomeIrmao1 = new JLabel("Nome:");
	JLabel nomeIrmao2 = new JLabel("Nome:");
	JLabel nomeIrmao3 = new JLabel("Nome:");
	JLabel dataNascimentoIrmao1 = new JLabel("Data de Nascimento:");
	JLabel dataNascimentoIrmao2 = new JLabel("Data de Nascimento:");
	JLabel dataNascimentoIrmao3 = new JLabel("Data de Nascimento:");
	
	JLabel nomePai = new JLabel("Nome do pai:");
	JLabel nomeMae = new JLabel("Nome da mãe:");
	JLabel telResPai = new JLabel("Tel. Residencial:");
	JLabel telResMae = new JLabel("Tel. Residencial:");
	JLabel celPai = new JLabel("Celular:");
	JLabel celMae = new JLabel("Celular:");
	JLabel telTrabPai = new JLabel("Tel. Trabalho:");
	JLabel telTrabMae = new JLabel("Tel. Trabalho:");
	JLabel ramal_pai = new JLabel("Ramal:");
	JLabel ramal_mae = new JLabel("Ramal:");
	JLabel end_pai = new JLabel("Endereço:");
	JLabel end_mae = new JLabel("Endereço:");
	JLabel bairro_pai = new JLabel("Bairro:");
	JLabel bairro_mae = new JLabel("Bairro:");
	JLabel cep_pai = new JLabel("CEP:");
	JLabel cep_mae = new JLabel("CEP:");
	JLabel num_pai = new JLabel("Nº:");
	JLabel num_mae = new JLabel("Nº:");
	JLabel email_pai = new JLabel("Email:");
	JLabel email_mae = new JLabel("Email:");
	JLabel membroPai = new JLabel("É membro de alguma igreja?");
	JLabel qualIgrejaPai = new JLabel("Qual?");
	JLabel melhorContatoPai = new JLabel("Melhor forma de contato:");
	JLabel membroMae = new JLabel("É membro de alguma igreja?");
	JLabel qualIgrejaMae = new JLabel("Qual?");
	JLabel melhorContatoMae = new JLabel("Melhor forma de contato");

	JRadioButton rb1 = new JRadioButton("Sim");
	JRadioButton rb2 = new JRadioButton("Não");
	JRadioButton rb3 = new JRadioButton("Sim");
	JRadioButton rb4 = new JRadioButton("Não");
	JRadioButton rb5 = new JRadioButton("Sim");
	JRadioButton rb6 = new JRadioButton("Não");
	JRadioButton rb7 = new JRadioButton("Residencial");
	JRadioButton rb8 = new JRadioButton("Trabalho");
	JRadioButton rb9 = new JRadioButton("Email");
	JRadioButton rb10 = new JRadioButton("Sim");
	JRadioButton rb11 = new JRadioButton("Não");
	JRadioButton rb12 = new JRadioButton("Residencial");
	JRadioButton rb13 = new JRadioButton("Trabalho");
	JRadioButton rb14 = new JRadioButton("Email");
	
	ButtonGroup group1 = new ButtonGroup();
	ButtonGroup group2 = new ButtonGroup();
	ButtonGroup group3 = new ButtonGroup();
	ButtonGroup group4 = new ButtonGroup();
	ButtonGroup group5 = new ButtonGroup();
	ButtonGroup group6 = new ButtonGroup();
	
	JTextField boxNome = new JTextField(); 
	JTextField boxIdade = new JTextField();
	JTextField boxTurma = new JTextField();
	JTextField alergiaAlimentos = new JTextField();
	JTextField boxNomeIrmao1 = new JTextField();
	JTextField boxNomeIrmao2 = new JTextField();
	JTextField boxNomeIrmao3 = new JTextField();
	
	
	JTextField boxNomePai = new JTextField();
	JTextField boxNomeMae = new JTextField();
	JTextField boxEndPai = new JTextField();
	JTextField boxEndMae = new JTextField();
	JTextField boxNumPai = new JTextField();
	JTextField boxNumMae = new JTextField();
	JTextField boxBairroPai = new JTextField();
	JTextField boxBairroMae = new JTextField();
	JTextField boxRamalTrabPai = new JTextField();
	JTextField boxRamalTrabMae = new JTextField();
	JTextField boxEmailPai = new JTextField();
	JTextField boxEmailMae = new JTextField();
	JTextField igrejaPai = new JTextField();
	JTextField igrejaMae = new JTextField();
	
	JFormattedTextField boxCepMae = new JFormattedTextField(Mascara("#####-###"));
	JFormattedTextField boxCepPai = new JFormattedTextField(Mascara("#####-###"));
	JFormattedTextField boxCelPai = new JFormattedTextField(Mascara("#####-####"));
	JFormattedTextField boxCelMae = new JFormattedTextField(Mascara("#####-####"));
	JFormattedTextField boxTelResPai = new JFormattedTextField(Mascara("####-####"));
	JFormattedTextField boxTelResMae = new JFormattedTextField(Mascara("####-####"));
	JFormattedTextField boxTelTrabPai = new JFormattedTextField(Mascara("####-####"));
	JFormattedTextField boxTelTrabMae = new JFormattedTextField(Mascara("####-####"));
	
	JComboBox comboBoxDia = new JComboBox();
	JComboBox comboBoxMes = new JComboBox();
	JComboBox comboBoxAno = new JComboBox();
	JComboBox comboBoxDia1 = new JComboBox();
	JComboBox comboBoxMes1 = new JComboBox();
	JComboBox comboBoxAno1 = new JComboBox();
	JComboBox comboBoxDia2 = new JComboBox();
	JComboBox comboBoxMes2 = new JComboBox();
	JComboBox comboBoxAno2 = new JComboBox();
	JComboBox comboBoxDia3 = new JComboBox();
	JComboBox comboBoxMes3 = new JComboBox();
	JComboBox comboBoxAno3 = new JComboBox();
	
	Font fonte = new Font("Kristen ITC",0,18);
	Font fonteBox = new Font("Bookman Old Style",0,15);
	
	public JanelaCadastro(Image imgGv){
		
		int i;
		frame.setSize(1340, 680);
		frame.setLocation(10,10);
		frame.setIconImage(imgGv);
		frame.setResizable(false);
		
		painel.setLayout(null);
		
		alergicoAlimentos.setLocation(10, 130);
		alergicoAlimentos.setSize(240,30);
		alergicoAlimentos.setFont(fonte);
		alergicoAlimentos2.setLocation(10, 170);
		alergicoAlimentos2.setSize(50,30);
		alergicoAlimentos2.setFont(fonte);
		alergiaAlimentos.setLocation(65, 170);
		alergiaAlimentos.setSize(290, 30);
		alergiaAlimentos.setFont(fonteBox);
		alergiaAlimentos.setEnabled(false);
				
		group1.add(rb1);
		group1.add(rb2);
		rb1.setLocation(250, 130);
		rb1.setSize(50,30);
		rb2.setLocation(300, 130);
		rb2.setSize(50,30);
		rb2.setSelected(true);
		
		possuiIrmaos.setLocation(10, 210);
		possuiIrmaos.setSize(130,30);
		possuiIrmaos.setFont(fonte);
		
		group2.add(rb3);
		group2.add(rb4);
		rb3.setLocation(200, 210);
		rb3.setSize(50,30);
		rb4.setLocation(300, 210);
		rb4.setSize(50,30);
		rb4.setSelected(true);
		
		nomeIrmao1.setSize(60, 30);
		nomeIrmao1.setLocation(10, 250);
		nomeIrmao1.setFont(fonte);
		nomeIrmao2.setSize(60, 30);
		nomeIrmao2.setLocation(10, 330);
		nomeIrmao2.setFont(fonte);
		nomeIrmao3.setSize(60, 30);
		nomeIrmao3.setLocation(10, 410);
		nomeIrmao3.setFont(fonte);
		boxNomeIrmao1.setSize(290, 30);
		boxNomeIrmao1.setEnabled(false);
		boxNomeIrmao1.setLocation(70,250);
		boxNomeIrmao1.setFont(fonteBox);
		boxNomeIrmao2.setEnabled(false);
		boxNomeIrmao2.setSize(290, 30);
		boxNomeIrmao2.setLocation(70,330);
		boxNomeIrmao2.setFont(fonteBox);
		boxNomeIrmao3.setSize(290, 30);
		boxNomeIrmao3.setLocation(70,410);
		boxNomeIrmao3.setFont(fonteBox);
		boxNomeIrmao3.setEnabled(false);
		
		
		dataNascimentoIrmao1.setSize(200,30);
		dataNascimentoIrmao1.setLocation(10, 290);
		dataNascimentoIrmao1.setFont(fonte);
		dataNascimentoIrmao2.setSize(200,30);
		dataNascimentoIrmao2.setLocation(10, 370);
		dataNascimentoIrmao2.setFont(fonte);
		dataNascimentoIrmao3.setSize(200,30);
		dataNascimentoIrmao3.setLocation(10, 450);
		dataNascimentoIrmao3.setFont(fonte);
		
		comboBoxDia1.setLocation(197,290);
		comboBoxDia1.setSize(50,30);
		comboBoxDia1.setFont(new Font("Bookman Old Style",0,12));
		for(i=1;i<=9;i++){
			comboBoxDia1.addItem("0"+i+"");
		}
		for(i=10;i<=31;i++){
			comboBoxDia1.addItem(""+i+"");
		}
		comboBoxDia1.setEnabled(false);
		
		comboBoxMes1.setLocation(246,290);
		comboBoxMes1.setSize(50,30);
		comboBoxMes1.setFont(new Font("Bookman Old Style",0,12));
		for(i=1;i<=9;i++){
			comboBoxMes1.addItem("0"+i+"");
		}
		for(i=10;i<=12;i++){
			comboBoxMes1.addItem(""+i+"");
		}
		comboBoxMes1.setEnabled(false);
				
		comboBoxAno1.setLocation(294,290);
		comboBoxAno1.setSize(61,30);
		comboBoxAno1.setFont(new Font("Bookman Old Style",0,12));
		for(i=1996;i<=2025;i++){
			comboBoxAno1.addItem(""+i+"");
		}
		comboBoxAno1.setEnabled(false);
		
		comboBoxDia2.setLocation(197,370);
		comboBoxDia2.setSize(50,30);
		comboBoxDia2.setFont(new Font("Bookman Old Style",0,12));
		for(i=1;i<=9;i++){
			comboBoxDia2.addItem("0"+i+"");
		}
		for(i=10;i<=31;i++){
			comboBoxDia2.addItem(""+i+"");
		}
		comboBoxDia2.setEnabled(false);
				
		comboBoxMes2.setLocation(246,370);
		comboBoxMes2.setSize(50,30);
		comboBoxMes2.setFont(new Font("Bookman Old Style",0,12));
		for(i=1;i<=9;i++){
			comboBoxMes2.addItem("0"+i+"");
		}
		for(i=10;i<=12;i++){
			comboBoxMes2.addItem(""+i+"");
		}
		comboBoxMes2.setEnabled(false);
				
		comboBoxAno2.setLocation(294,370);
		comboBoxAno2.setSize(61,30);
		comboBoxAno2.setFont(new Font("Bookman Old Style",0,12));
		for(i=1996;i<=2025;i++){
			comboBoxAno2.addItem(""+i+"");
		}
		comboBoxAno2.setEnabled(false);
		
		comboBoxDia3.setLocation(197,450);
		comboBoxDia3.setSize(50,30);
		comboBoxDia3.setFont(new Font("Bookman Old Style",0,12));
		for(i=1;i<=9;i++){
			comboBoxDia3.addItem("0"+i+"");
		}
		for(i=10;i<=31;i++){
			comboBoxDia3.addItem(""+i+"");
		}
		comboBoxDia3.setEnabled(false);
				
		comboBoxMes3.setLocation(246,450);
		comboBoxMes3.setSize(50,30);
		comboBoxMes3.setFont(new Font("Bookman Old Style",0,12));
		for(i=1;i<=9;i++){
			comboBoxMes3.addItem("0"+i+"");
		}
		for(i=10;i<=12;i++){
			comboBoxMes3.addItem(""+i+"");
		}
		comboBoxMes3.setEnabled(false);
				
		comboBoxAno3.setLocation(294,450);
		comboBoxAno3.setSize(61,30);
		comboBoxAno3.setFont(new Font("Bookman Old Style",0,12));
		for(i=1996;i<=2025;i++){
			comboBoxAno3.addItem(""+i+"");
		}
		comboBoxAno3.setEnabled(false);
		
		ok.setSize(110,43);
		ok.setLocation(530, 550);
		
		cancelar.setSize(118, 43);
		cancelar.setLocation(650,550);
		
		nomeCrianca.setLocation( 10, 10);
		nomeCrianca.setSize(60, 30);
		nomeCrianca.setFont(fonte);
		boxNome.setLocation(70,10);
		boxNome.setSize(290,30);
		boxNome.setFont(fonteBox);
				
		dataNascimento.setLocation(10, 50);
		dataNascimento.setSize(200, 30);
		dataNascimento.setFont(fonte);
		comboBoxDia.setLocation(197,50);
		comboBoxDia.setSize(50,30);
		comboBoxDia.setFont(new Font("Bookman Old Style",0,12));
		for(i=1;i<=9;i++){
			comboBoxDia.addItem("0"+i+"");
		}
		for(i=10;i<=31;i++){
			comboBoxDia.addItem(""+i+"");
		}
				
		comboBoxMes.setLocation(246,50);
		comboBoxMes.setSize(50,30);
		comboBoxMes.setFont(new Font("Bookman Old Style",0,12));
		for(i=1;i<=9;i++){
			comboBoxMes.addItem("0"+i+"");
		}
		for(i=10;i<=12;i++){
			comboBoxMes.addItem(""+i+"");
		}
				
		comboBoxAno.setLocation(294,50);
		comboBoxAno.setSize(61,30);
		comboBoxAno.setFont(new Font("Bookman Old Style",0,12));
		for(i=1996;i<=2025;i++){
			comboBoxAno.addItem(""+i+"");
		}
				
		idade.setLocation(10, 90);
		idade.setSize(60, 30);
		idade.setFont(fonte);
		boxIdade.setLocation(70,90);
		boxIdade.setSize(40,30);
		boxIdade.setFont(fonteBox);
		boxIdade.setEditable(false);
		
		turma.setLocation(120, 90);
		turma.setSize(65, 30);
		turma.setFont(fonte);
		boxTurma.setLocation(185,90);
		boxTurma.setSize(110,30);
		boxTurma.setFont(fonteBox);
		boxTurma.setEditable(false);


		
		nomePai.setSize(120, 30);
		nomePai.setLocation(400,10);
		nomePai.setFont(fonte);
		boxNomePai.setLocation(520,10);
		boxNomePai.setSize(330, 30);
		boxNomePai.setFont(fonteBox);
		
		end_pai.setLocation(400,50);
		end_pai.setSize(95, 30);
		end_pai.setFont(fonte);
		boxEndPai.setSize(350, 30);
		boxEndPai.setLocation(500, 50);
		boxEndPai.setFont(fonteBox);
		
		num_pai.setSize(50, 30);
		num_pai.setLocation(400, 90);
		num_pai.setFont(fonte);
		boxNumPai.setSize(60, 30);
		boxNumPai.setLocation(430, 90);
		boxNumPai.setFont(fonteBox);
		
		bairro_pai.setSize(80, 30);
		bairro_pai.setLocation(510, 90);
		bairro_pai.setFont(fonte);
		boxBairroPai.setLocation(570, 90);
		boxBairroPai.setSize(110, 30);
		boxBairroPai.setFont(fonteBox);
		
		cep_pai.setLocation(700, 90);
		cep_pai.setSize(50,30);
		cep_pai.setFont(fonte);
		boxCepPai.setLocation(745, 90);
		boxCepPai.setSize(105, 30);
		boxCepPai.setFont(fonteBox);
		
		telResPai.setFont(fonte);
		telResPai.setLocation(400,130);
		telResPai.setSize(190, 30);
		boxTelResPai.setSize(105, 30);
		boxTelResPai.setLocation(545, 130);
		boxTelResPai.setFont(fonteBox);
		
		celPai.setLocation(675,130);
		celPai.setSize(130,30);
		celPai.setFont(fonte);
		boxCelPai.setLocation(745, 130);
		boxCelPai.setSize(105,30);
		boxCelPai.setFont(fonteBox);
		
		telTrabPai.setSize(190,30);
		telTrabPai.setLocation(400, 170);
		telTrabPai.setFont(fonte);
		boxTelTrabPai.setLocation(530,170);
		boxTelTrabPai.setSize(105,30);
		boxTelTrabPai.setFont(fonteBox);
		
		ramal_pai.setLocation(675, 170);
		ramal_pai.setSize(80,30);
		ramal_pai.setFont(fonte);
		boxRamalTrabPai.setLocation(735,170);
		boxRamalTrabPai.setSize(115,30);
		boxRamalTrabPai.setFont(fonteBox);
		
		email_pai.setLocation(400, 210);
		email_pai.setSize(55, 30);
		email_pai.setFont(fonte);
		boxEmailPai.setLocation(455,210);
		boxEmailPai.setSize(395,30);
		boxEmailPai.setFont(fonteBox);
		
		melhorContatoPai.setLocation(400, 250);
		melhorContatoPai.setSize(230,30);
		melhorContatoPai.setFont(fonte);
		
		group3.add(rb7);
		group3.add(rb8);
		group3.add(rb9);
		rb7.setLocation(640, 250);
		rb7.setSize(90,30);
		rb7.setSelected(true);
		rb8.setLocation(740, 250);
		rb8.setSize(90,30);
		rb9.setLocation(640, 290);
		rb9.setSize(90,30);
			
		membroPai.setLocation(400,330);
		membroPai.setSize(250,30);
		membroPai.setFont(fonte);
		
		group4.add(rb5);
		group4.add(rb6);
		rb5.setLocation(660, 330);
		rb5.setSize(90,30);
		rb5.setSelected(true);
		rb6.setLocation(750, 330);
		rb6.setSize(90,30);
		
		qualIgrejaPai.setSize(60,30);
		qualIgrejaPai.setLocation(400,370);
		qualIgrejaPai.setFont(fonte);
		igrejaPai.setLocation(470, 370);
		igrejaPai.setSize(375,30);
		igrejaPai.setFont(fonteBox);
		
		nomeMae.setSize(135, 30);
		nomeMae.setLocation(860,10);
		nomeMae.setFont(fonte);
		boxNomeMae.setLocation(980,10);
		boxNomeMae.setSize(330, 30);
		boxNomeMae.setFont(fonteBox);
		
		end_mae.setLocation(860,50);
		end_mae.setSize(95, 30);
		end_mae.setFont(fonte);
		boxEndMae.setSize(350, 30);
		boxEndMae.setLocation(960, 50);
		boxEndMae.setFont(fonteBox);
		
		num_mae.setSize(50, 30);
		num_mae.setLocation(860, 90);
		num_mae.setFont(fonte);
		boxNumMae.setSize(60, 30);
		boxNumMae.setLocation(890, 90);
		boxNumMae.setFont(fonteBox);
		
		bairro_mae.setSize(80, 30);
		bairro_mae.setLocation(970, 90);
		bairro_mae.setFont(fonte);
		boxBairroMae.setLocation(1030, 90);
		boxBairroMae.setSize(110, 30);
		boxBairroMae.setFont(fonteBox);
		
		cep_mae.setLocation(1160, 90);
		cep_mae.setSize(50,30);
		cep_mae.setFont(fonte);
		boxCepMae.setLocation(1205, 90);
		boxCepMae.setSize(105, 30);
		boxCepMae.setFont(fonteBox);
		
		telResMae.setFont(fonte);
		telResMae.setLocation(860,130);
		telResMae.setSize(190, 30);
		boxTelResMae.setSize(105, 30);
		boxTelResMae.setLocation(545+460, 130);
		boxTelResMae.setFont(fonteBox);
		
		celMae.setLocation(675+460,130);
		celMae.setSize(130,30);
		celMae.setFont(fonte);
		boxCelMae.setLocation(745+460, 130);
		boxCelMae.setSize(105,30);
		boxCelMae.setFont(fonteBox);
		
		telTrabMae.setSize(190,30);
		telTrabMae.setLocation(860, 170);
		telTrabMae.setFont(fonte);
		boxTelTrabMae.setLocation(530+460,170);
		boxTelTrabMae.setSize(105,30);
		boxTelTrabMae.setFont(fonteBox);
		
		ramal_mae.setLocation(675+460, 170);
		ramal_mae.setSize(80,30);
		ramal_mae.setFont(fonte);
		boxRamalTrabMae.setLocation(735+460,170);
		boxRamalTrabMae.setSize(115,30);
		boxRamalTrabMae.setFont(fonteBox);
		
		email_mae.setLocation(860, 210);
		email_mae.setSize(55, 30);
		email_mae.setFont(fonte);
		boxEmailMae.setLocation(455+460,210);
		boxEmailMae.setSize(395,30);
		boxEmailMae.setFont(fonteBox);
		
		melhorContatoMae.setLocation(860, 250);
		melhorContatoMae.setSize(230,30);
		melhorContatoMae.setFont(fonte);
		
		group5.add(rb12);
		group5.add(rb13);
		group5.add(rb14);
		rb12.setLocation(640+460, 250);
		rb12.setSize(90,30);
		rb12.setSelected(true);
		rb13.setLocation(740+460, 250);
		rb13.setSize(90,30);
		rb14.setLocation(640+460, 290);
		rb14.setSize(90,30);
			
		membroMae.setLocation(860,330);
		membroMae.setSize(250,30);
		membroMae.setFont(fonte);
		
		group6.add(rb10);
		group6.add(rb11);
		rb10.setLocation(660+460, 330);
		rb10.setSize(90,30);
		rb10.setSelected(true);
		rb11.setLocation(750+460, 330);
		rb11.setSize(90,30);
		
		qualIgrejaMae.setSize(60,30);
		qualIgrejaMae.setLocation(860,370);
		qualIgrejaMae.setFont(fonte);
		igrejaMae.setLocation(470+460, 370);
		igrejaMae.setSize(375,30);
		igrejaMae.setFont(fonteBox);
		
		//add
		painel.add(igrejaPai);
		painel.add(qualIgrejaPai);
		painel.add(membroPai);
		painel.add(rb5);
		painel.add(rb6);
		painel.add(rb7);
		painel.add(rb8);
		painel.add(rb9);
		painel.add(rb14);
		painel.add(rb10);
		painel.add(rb11);
		painel.add(rb12);
		painel.add(rb13);
		painel.add(melhorContatoPai);
		painel.add(boxEmailPai);
		painel.add(email_pai);
		painel.add(boxRamalTrabPai);
		painel.add(boxTelTrabPai);
		painel.add(boxCelPai);
		painel.add(boxTelResPai);
		painel.add(boxCepPai);
		painel.add(boxBairroPai);
		painel.add(boxNumPai);
		painel.add(boxEndPai);
		painel.add(ramal_pai);
		painel.add(telTrabPai);
		painel.add(cep_pai);
		painel.add(bairro_pai);
		painel.add(num_pai);
		painel.add(end_pai);
		painel.add(telResMae);
		painel.add(boxTelResMae);
        painel.add(igrejaMae);
		painel.add(qualIgrejaMae);
		painel.add(membroMae);
		painel.add(melhorContatoMae);
		painel.add(boxEmailMae);
		painel.add(email_mae);
		painel.add(boxRamalTrabMae);
		painel.add(boxTelTrabMae);
		painel.add(boxCelMae);		
		painel.add(boxCepMae);
		painel.add(boxBairroMae);
		painel.add(boxNumMae);
		painel.add(boxEndMae);
		painel.add(ramal_mae);
		painel.add(telTrabMae);
		painel.add(cep_mae);
		painel.add(bairro_mae);
		painel.add(num_mae);
		painel.add(end_mae);
		painel.add(boxNomeIrmao1);
		painel.add(boxNomeIrmao2);
		painel.add(boxNomeIrmao3);
		painel.add(dataNascimentoIrmao1);
		painel.add(dataNascimentoIrmao2);
		painel.add(dataNascimentoIrmao3);
		painel.add(nomeIrmao1);
		painel.add(nomeIrmao2);
		painel.add(nomeIrmao3);
		painel.add(possuiIrmaos);
		painel.add(alergiaAlimentos);
		painel.add(alergicoAlimentos2);
		painel.add(rb1);
		painel.add(rb2);
		painel.add(rb3);
		painel.add(rb4);
		painel.add(alergicoAlimentos);
		painel.add(comboBoxAno);
		painel.add(comboBoxMes);
		painel.add(comboBoxDia);
		painel.add(comboBoxAno1);
		painel.add(comboBoxMes1);
		painel.add(comboBoxDia1);
		painel.add(comboBoxAno2);
		painel.add(comboBoxMes2);
		painel.add(comboBoxDia2);
		painel.add(comboBoxAno3);
		painel.add(comboBoxMes3);
		painel.add(comboBoxDia3);
		painel.add(nomeMae);
		painel.add(boxNomeMae);
		painel.add(celMae);
		painel.add(boxCelMae);
		painel.add(boxCelPai);
		painel.add(celPai);
		painel.add(boxNomePai);
		painel.add(nomePai);
		painel.add(telResPai);
		painel.add(boxTelResPai);
		painel.add(dataNascimento);
		painel.add(boxIdade);
		painel.add(idade);
		painel.add(turma);
		painel.add(boxTurma);
		painel.add(boxNome);
		painel.add(nomeCrianca);
		painel.add(ok);
		painel.add(cancelar);
		frame.add(painel);
		
		rb1.addActionListener(this);
		rb2.addActionListener(this);
		rb3.addActionListener(this);
		rb4.addActionListener(this);
		rb5.addActionListener(this);
		rb6.addActionListener(this);
		rb10.addActionListener(this);
		rb11.addActionListener(this);
		ok.addActionListener(this);
		cancelar.addActionListener(this);
		
		boxIdade.addFocusListener(this);
		comboBoxDia.addFocusListener(this);
		comboBoxMes.addFocusListener(this);
		comboBoxAno.addFocusListener(this);
		
		frame.setVisible(true);
		
	}

	//CONEXÃO COM O BANCO DE DADOS!!
	public Connection accessDatabase(String a2, String b, String c, String d, String e, String f) throws SQLException {
		cont++;
		numero=cont;
		int i;
		try {  
			    
	            String url = "jdbc:postgresql://localhost:5432/geracaovida_alunos";  
	            String usuario = "postgres";  
	            String senha = "admin0123"; 
	            Connection con=null;  
	            Statement stm=null;
	            String alergiaSN, alergiaOq,irmaos,nomeIr1,nomeIr2,nomeIr3, data1, data2, data3;
				String nome, idade, turma, dataN, nomeDoPai, endPai, celuPai,  telResiPai,numeroPai,baiPai,CEPPai,trabPai,ramalPai,emailPai,contatoPai,membroIgrejaPai, simNaoPai; 
				String nomeDaMae, endMae, celuMae,  telResiMae,numeroMae,baiMae,CEPMae,trabMae,ramalMae,emailMae,contatoMae,membroIgrejaMae, simNaoMae;
				ResultSet index; 
				Object result;
	            
				try{  
	                Class.forName("org.postgresql.Driver"); 
	                con = DriverManager.getConnection(url, usuario, senha);    
	                stm = con.createStatement();     
	            }  
	            catch(SQLException a){    
	                  a.printStackTrace();  
	                  JOptionPane.showMessageDialog(null, "Problemas de conexão com o banco de dados");  
	            }   
	            catch(ClassNotFoundException a){  
	                a.printStackTrace();  
	                JOptionPane.showMessageDialog(null, "Problemas de conexão com o banco de dados"); 
	            }
	            
	            nome = boxNome.getText();
	            nome = nome.toLowerCase();
	            idade = boxIdade.getText();
	            turma = boxTurma.getText();
	            dataN = (String) comboBoxDia.getSelectedItem()+"/"+(String)comboBoxMes.getSelectedItem()+"/"+(String)comboBoxAno.getSelectedItem();
	            //alergiaSN
	            alergiaOq = alergiaAlimentos.getText();
	            //irmaos
	            nomeIr1 = boxNomeIrmao1.getText();
	            nomeIr2 = boxNomeIrmao2.getText();
	            nomeIr3 = boxNomeIrmao3.getText();
	            data1 = (String) comboBoxDia1.getSelectedItem()+"/"+(String)comboBoxMes1.getSelectedItem()+"/"+(String)comboBoxAno1.getSelectedItem();
	            data2 = (String) comboBoxDia2.getSelectedItem()+"/"+(String)comboBoxMes2.getSelectedItem()+"/"+(String)comboBoxAno2.getSelectedItem();
	            data3 = (String) comboBoxDia3.getSelectedItem()+"/"+(String)comboBoxMes3.getSelectedItem()+"/"+(String)comboBoxAno3.getSelectedItem();
	            
	            nomeDoPai = boxNomePai.getText();
	            nomeDoPai = nomeDoPai.toLowerCase();
	            endPai = boxEndPai.getText();
	            numeroPai = boxNumPai.getText();
	            baiPai = boxBairroPai.getText();
	            CEPPai = boxCepPai.getText();
	            trabPai = boxTelTrabPai.getText();
	            ramalPai = boxRamalTrabPai.getText();
	            emailPai = boxEmailPai.getText();
	            //contatoPai
	            //simNaoPai
	            membroIgrejaPai = igrejaPai.getText();
	            celuPai = boxCelPai.getText();
	            telResiPai = boxTelResPai.getText();
	           
	            nomeDaMae = boxNomeMae.getText();
	            nomeDaMae = nomeDaMae.toLowerCase();
	            endMae = boxEndMae.getText();
	            numeroMae = boxNumMae.getText();
	            baiMae = boxBairroMae.getText();
	            CEPMae = boxCepMae.getText();
	            trabMae = boxTelTrabMae.getText();
	            ramalMae = boxRamalTrabMae.getText();
	            emailMae = boxEmailMae.getText();
	            //contatoMae
	            //simNaoMae
	            membroIgrejaMae = igrejaMae.getText();
	            celuMae = boxCelMae.getText();
	            telResiMae = boxTelResMae.getText();
	            
	            index = stm.executeQuery("SELECT MAX(id) from pais;");
	            index.next();
	            result = index.getInt(1);
	            if ((nome.equals(""))||(idade.equals(""))||((nomeDoPai.equals(""))&&(nomeDaMae.equals("")))||((telResiPai.equals(""))&&(telResiMae.equals("")))){
	            	JOptionPane.showMessageDialog(frame, "Os seguintes dados são necessários:\n"
	            			+ "- Nome;\n"
	            			+ "- Idade;\n"
	            			+ "- Tel. Residencial do pai ou da mãe\n"
	            			+ "- Nome do pai ou da mãe.", "Aviso", 0);
	            	
	            }
	            else{
	            	
		            if((int)result==0){
		            	stm.execute("INSERT INTO pais (nome_pai,tel_residencia_pai,tel_pai,tel_trabalho_pai,ramal_trabalho_pai,end_pai,cep_pai,bairro_pai,email_pai"
		            			+ ",forma_contato_pai,membro_pai,igreja_pai,nome_mae,tel_residencia_mae"
		            			+ ",tel_mae,tel_trabalho_mae,ramal_trabalho_mae,end_mae,cep_mae,bairro_mae,"
		            			+ "email_mae,forma_contato_mae,membro_mae,igreja_mae,id,numero,numero_mae) VALUES ('"+nomeDoPai+"','"+telResiPai+"','"+celuPai+"','"+trabPai+"','"+ramalPai+"','"+endPai+"','"+CEPPai+"','"+baiPai+"','"+emailPai+"','"+d+"','"+c+"','"+membroIgrejaPai+"'"
		            					+ ",'"+nomeDaMae+"','"+telResiMae+"','"+celuMae+"','"+trabMae+"','"+ramalMae+"','"+endMae+"','"+CEPMae+"','"+baiMae+"','"+emailMae+"','"+f+"','"+e+"','"+membroIgrejaMae+"','"+numero+"','"+numeroPai+"','"+numeroMae+"');");
		            	
		            	stm.execute("INSERT INTO crianca (nome,id,idade,turma,data_aniversario,id_pais,alergia,alergico,irmaos,nomeirmao1,nomeirmao2,nomeirmao3,data_aniversario_irmao1,data_aniversario_irmao2,data_aniversario_irmao3)"
		            			+ " VALUES ('"+nome+"','"+numero+"','"+idade+"','"+turma+"','"+dataN+"','"+numero+"','"+a2+"','"+alergiaOq+"','"+b+"','"+nomeIr1+"','"+nomeIr2+"','"+nomeIr3+"','"+data1+"','"+data2+"','"+data3+"');"); 
		            }
		            else{
		            	
		            	numero=(int)result+1;
		            	stm.execute("INSERT INTO pais (nome_pai,tel_residencia_pai,tel_pai,tel_trabalho_pai,ramal_trabalho_pai,end_pai,cep_pai,bairro_pai,email_pai"
		            			+ ",forma_contato_pai,membro_pai,igreja_pai,nome_mae,tel_residencia_mae"
		            			+ ",tel_mae,tel_trabalho_mae,ramal_trabalho_mae,end_mae,cep_mae,bairro_mae,"
		            			+ "email_mae,forma_contato_mae,membro_mae,igreja_mae,id,numero,numero_mae) VALUES ('"+nomeDoPai+"','"+telResiPai+"','"+celuPai+"','"+trabPai+"','"+ramalPai+"','"+endPai+"','"+CEPPai+"','"+baiPai+"','"+emailPai+"','"+d+"','"+c+"','"+membroIgrejaPai+"'"
		            					+ ",'"+nomeDaMae+"','"+telResiMae+"','"+celuMae+"','"+trabMae+"','"+ramalMae+"','"+endMae+"','"+CEPMae+"','"+baiMae+"','"+emailMae+"','"+f+"','"+e+"','"+membroIgrejaMae+"','"+numero+"','"+numeroPai+"','"+numeroMae+"');");
		            	
		            	stm.execute("INSERT INTO crianca (nome,id,idade,turma,data_aniversario,id_pais,alergia,alergico,irmaos,nomeirmao1,nomeirmao2,nomeirmao3,data_aniversario_irmao1,data_aniversario_irmao2,data_aniversario_irmao3)"
		            			+ " VALUES ('"+nome+"','"+numero+"','"+idade+"','"+turma+"','"+dataN+"','"+numero+"','"+a2+"','"+alergiaOq+"','"+b+"','"+nomeIr1+"','"+nomeIr2+"','"+nomeIr3+"','"+data1+"','"+data2+"','"+data3+"');");
		            }
		            
		            JOptionPane.showMessageDialog(frame, "Novo aluno cadastrado com sucesso", "Cadastrado com sucesso", 1);
		            frame.dispose();
		            con.close();  
	            }   
            } 
			catch (Exception a) {     
                a.printStackTrace();  
            }
		
		
		return null;
	}	
	
	
	
	public MaskFormatter Mascara(String Mascara){  
        
	       MaskFormatter F_Mascara = new MaskFormatter();  
	       try{  
	           F_Mascara.setMask(Mascara); //Atribui a mascara  
	           F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento   
	       }  
	       catch (Exception excecao) {  
	       excecao.printStackTrace();  
	       }   
	       return F_Mascara;
	       //JFormattedTextField Campo = new JFormattedTextField(Mascara("##/##/####"));
	} 
	
	
	@Override
	public void actionPerformed(ActionEvent z) {
		String a,b,c,d,e,f;
		
		
		if(z.getSource()==cancelar){
			frame.dispose();
		}
		if(z.getSource()==ok){
			
			a=null;
			b=null;
			c=null;
			d=null;
			e=null;
			f=null;
			if(rb1.isSelected())
				a=rb1.getText();
			if(rb2.isSelected())
				a=rb2.getText();
			
			if(rb3.isSelected())
				b=rb3.getText();
			if(rb4.isSelected())
				b=rb4.getText();
			
			if(rb5.isSelected())
				c=rb5.getText();
			if(rb6.isSelected())
				c=rb6.getText();
			
			if(rb7.isSelected())
				d=rb7.getText();			
			if(rb8.isSelected())
				d=rb8.getText();
			if(rb9.isSelected())
				d=rb9.getText();
			
			if(rb10.isSelected())
				e=rb10.getText();
			if(rb11.isSelected())
				e=rb11.getText();
			
			if(rb12.isSelected())
				f=rb12.getText();			
			if(rb13.isSelected())
				f=rb13.getText();
			if(rb14.isSelected())
				f=rb14.getText();
			try {
				this.accessDatabase(a,b,c,d,e,f);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
		if(z.getSource()==rb1){
			alergiaAlimentos.setEnabled(true);
		}
		if(z.getSource()==rb2){
			alergiaAlimentos.setEnabled(false);
		}
		if(z.getSource()==rb3){
			boxNomeIrmao1.setEnabled(true);
			boxNomeIrmao2.setEnabled(true);
			boxNomeIrmao3.setEnabled(true);
			comboBoxDia1.setEnabled(true);
			comboBoxDia2.setEnabled(true);
			comboBoxDia3.setEnabled(true);
			comboBoxMes1.setEnabled(true);
			comboBoxMes2.setEnabled(true);
			comboBoxMes3.setEnabled(true);
			comboBoxAno1.setEnabled(true);
			comboBoxAno2.setEnabled(true);
			comboBoxAno3.setEnabled(true);
			
		}
		if(z.getSource()==rb4){
			boxNomeIrmao1.setEnabled(false);
			boxNomeIrmao2.setEnabled(false);
			boxNomeIrmao3.setEnabled(false);
			comboBoxDia1.setEnabled(false);
			comboBoxDia2.setEnabled(false);
			comboBoxDia3.setEnabled(false);
			comboBoxMes1.setEnabled(false);
			comboBoxMes2.setEnabled(false);
			comboBoxMes3.setEnabled(false);
			comboBoxAno1.setEnabled(false);
			comboBoxAno2.setEnabled(false);
			comboBoxAno3.setEnabled(false);
		}
		
		if(z.getSource()==rb5){
			igrejaPai.setEnabled(true);
		}
		
		if(z.getSource()==rb6){
			igrejaPai.setEnabled(false);
		}
		if(z.getSource()==rb10){
			igrejaMae.setEnabled(true);
		}
		
		if(z.getSource()==rb11){
			igrejaMae.setEnabled(false);
		}
		
	}

	@Override
	public void focusGained(FocusEvent f) {
	}

	@Override
	public void focusLost(FocusEvent f) {

		if(f.getSource() == comboBoxDia ||f.getSource() == comboBoxMes ||f.getSource() == comboBoxAno){
			Utils util = new Utils();
			String idadeConvertida;
			int i;
			i = util.calculaIdade((String) comboBoxDia.getSelectedItem()+"-"+(String)comboBoxMes.getSelectedItem()+"-"+(String)comboBoxAno.getSelectedItem(),"dd-MM-yyyy");
			idadeConvertida = "" + i; 			
			boxIdade.setText(idadeConvertida);
			
				
			if((boxIdade.getText()).equals("0"))
				boxTurma.setText("berçário");
			if((boxIdade.getText()).equals("1"))
				boxTurma.setText("1 ano");
			if((boxIdade.getText()).equals("2")||(boxIdade.getText()).equals("3"))
				boxTurma.setText("2 e 3 anos");
			if((boxIdade.getText()).equals("4")||(boxIdade.getText()).equals("5"))
				boxTurma.setText("4 e 5 anos");
			if((boxIdade.getText()).equals("6")||(boxIdade.getText()).equals("7"))
				boxTurma.setText("6 e 7 anos");
			if((boxIdade.getText()).equals("8")||(boxIdade.getText()).equals("9"))
				boxTurma.setText("8 e 9 anos");
			if((boxIdade.getText()).equals("10")||(boxIdade.getText()).equals("11"))
					boxTurma.setText("10 e 11 anos");		
			if(!((boxIdade.getText()).equals("0")||(boxIdade.getText()).equals("1")||(boxIdade.getText()).equals("2")||(boxIdade.getText()).equals("3")||
					(boxIdade.getText()).equals("4")||(boxIdade.getText()).equals("5")||(boxIdade.getText()).equals("6")||(boxIdade.getText()).equals("7")||
					(boxIdade.getText()).equals("8")||(boxIdade.getText()).equals("9")||(boxIdade.getText()).equals("10")||(boxIdade.getText()).equals("11")))		
				boxTurma.setText("");
		}
			
	
		
	}

}