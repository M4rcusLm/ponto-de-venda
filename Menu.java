import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu { // FAZER TUDO COM INTERFACE GRÁFICA JFRAME
	
	public static Produto prod;
	Funcionario func;
	Adm adm;
	private String codigo = "12345";
	static boolean prodFlag = false;
	static boolean funcFlag = false;
	JTextField senha;
	JTextField login;
	
	public Menu() {
		prod = new Produto();
		func = new Funcionario();
		adm = new Adm();
		adm.setNome("Marcus");
		adm.setEmail("teste");
		adm.setSenha("123");
		
		login();
	}
	
	public void login() {

		JFrame telaLogin = new JFrame("Início");
		telaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaLogin.setLayout(null);
		telaLogin.setSize(300, 350);
		telaLogin.getContentPane().setBackground(Color.GRAY);
		telaLogin.setResizable(false);
		telaLogin.setLocationRelativeTo(null);
		telaLogin.setVisible(true);

		JLabel lblNome = new JLabel("Login:");
		lblNome.setBounds(40, 70, 50, 20);
		lblNome.setForeground(Color.BLACK);
		lblNome.setVisible(true);

		senha = new JTextField();
		senha.setBounds(40, 110, 200, 30);
		senha.setVisible(true);

		login = new JTextField();
		login.setBounds(40, 70, 200,30);
		login.setVisible(true);

		JButton entrar = new JButton("Entrar");
		entrar.setBounds(40, 170, 200, 40);
		entrar.setBackground(new Color(70, 80, 200));
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btmEntrar(evt);
			}
		});

		JButton registrar = new JButton("Registrar");
		registrar.setBounds(40, 220, 200, 40);
		registrar.setBackground(new Color(70, 80, 200));
		registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btmRegistrar(evt);
			}
		});

		telaLogin.add(lblNome);
		telaLogin.add(login);
		telaLogin.add(senha);
		telaLogin.add(entrar);
		telaLogin.add(registrar);

/*
		String login, senha;
		String[] opcoes = {"Entrar", "Registrar", "Sair"};
		int resp;
		do {
			resp = JOptionPane.showOptionDialog(null, "Bem vindo ao Ponto de venda, escolha uma opção para entrar no sistema.", "Início", 0, 1, null, opcoes, opcoes[0]);
			
			switch(resp) {
			case 0:
				
				login = JOptionPane.showInputDialog(null, "Seu login:", "Entrar", JOptionPane.PLAIN_MESSAGE);
				
				if(login != null) {
					
					senha = JOptionPane.showInputDialog(null, "Sua senha:", "Entrar", JOptionPane.PLAIN_MESSAGE);
					
					if(senha != null) {
						
						if(login.equals(adm.getEmail()) && senha.equals(adm.getSenha())) {
							
							telaAdm();
							
						} else if(login.equals(func.getEmail()) && senha.equals(func.getSenha())) {
							
							telaFunc();
							
						} else {
							
							JOptionPane.showMessageDialog(null, "Login ou senha inválidos, tente novamente.", "Entrar", JOptionPane.ERROR_MESSAGE);
							
						}
						
					} else {
						JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos");
					}
					
				}
				break;
				
			case 1:
				
				String[] opt = {"Alterar Adm", "Registrar funcionário", "Voltar"};
				int aux;
				do {
					String code = JOptionPane.showInputDialog(null, "Não lembra do login e senha do Adm?\nEntre com o código do Adm para alterar os dados do adm ou cadastrar um funcionário.", "Verificação", JOptionPane.INFORMATION_MESSAGE);
					if(code == null) {
						code = "";
					}
					if(code.equals(codigo)) {
					
						do {
							aux = JOptionPane.showOptionDialog(null, "Escolha o perfil para registrar.", "Registrar", 0, 1, null, opt, opt[0]);
					
							switch(aux) {
							case 0:
								adm.alterarAdm();
								break;
							case 1:
								func.cadastrarFuncionario();
								break;
							case 2:
							
							default:
								break;
							}
						} while(aux != 2);
					
					} else {
						if(code != "") {
							JOptionPane.showMessageDialog(null, "O código inserido não é válido.", "Verificação", JOptionPane.ERROR_MESSAGE);
						}
						aux = 2;
					}
				} while(aux != 2);
				
				break;
				
			case 2:
				
			default:
				resp = 2;
				break;
			}
			
		} while (resp != 2);
		*/
	}
	
	public void telaAdm() {
		String[] opcoes = {"Realizar venda", "Cadastrar funcionário", "Consultar funcionário", "Cadastrar produto", "Consultar produto", "Perfil", "Logout"};
		int resp;
		do {
			resp = JOptionPane.showOptionDialog(null, "Escolha uma opção para continuar", "Principal - Adm", 0, 1, null, opcoes, opcoes[0]);
			switch(resp) {
				case 0:
					if(prodFlag) {
						adm.realizarVenda();
					} else {
						JOptionPane.showMessageDialog(null, "O Adm deve cadastrar um produto antes.", "Realizando venda", JOptionPane.WARNING_MESSAGE);
					}
					break;
				case 1:
					adm.cadastrarFuncionario();
					break;
				case 2:
					if(funcFlag) {
						adm.consultarFunc();
					} else {
						JOptionPane.showMessageDialog(null, "O Adm deve cadastrar um funcionário antes.", "Realizando venda", JOptionPane.WARNING_MESSAGE);
					}
					break;
				case 3:
					prod.cadastrarProduto();
					break;
				case 4:
					if(prodFlag) {
						prod.consultarProduto();
					} else {
						JOptionPane.showMessageDialog(null, "O Adm deve cadastrar um produto antes.", "Realizando venda", JOptionPane.WARNING_MESSAGE);
					}
					break;
				case 5:
					adm.consultarAdm();
					break;
				case 6:

				default:
					resp = 6;
					break;
			}
		} while(resp != 6);
	}
	
	public void telaFunc() {
		String[] opcoes = {"Realizar venda", "Consultar produto", "Perfil", "Logout"};
		int resp;
		do {
			resp = JOptionPane.showOptionDialog(null, "Escolha uma opção para continuar", "Principal - Funcionário", 0, 1, null, opcoes, opcoes[0]);
			switch(resp) {
				case 0:
					if(prodFlag) {
						prod.consultarProduto();
					} else {
						JOptionPane.showMessageDialog(null, "O Adm deve cadastrar um produto antes.", "Realizando venda", JOptionPane.WARNING_MESSAGE);
					}
					break;
				case 1:
					if(prodFlag) {
						prod.consultarProduto();
					} else {
						JOptionPane.showMessageDialog(null, "O Adm deve cadastrar um produto antes.", "Realizando venda", JOptionPane.WARNING_MESSAGE);
					}
					break;
				case 2:
					func.consultarFunc();
					break;
				case 3:

				default:
					resp = 3;
					break;
		}
		} while(resp != 3);
	}

	public void btmEntrar(ActionEvent evt) {

	}

	public void btmRegistrar(ActionEvent evt) {
		String code = JOptionPane.showInputDialog(login, "Entre com o código do Adm para se registrar como funcionário imediatamente.", "Verificação", JOptionPane.INFORMATION_MESSAGE);
		if(code == null) {
			code = "";
		} else {
			if(code.equals(codigo)){
				//func.cadastrarFuncionario();
				func.setEmail(login.getText());
				func.setSenha(senha.getText());
				JOptionPane.showMessageDialog(login, "Cadastrado com sucesso.", "Registrando", 1);
			} else {
				JOptionPane.showMessageDialog(login, "Código inválido, tente novamente.", "Verificação", 2);
			}
		}
	}
}
