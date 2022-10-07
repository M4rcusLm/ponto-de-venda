import javax.swing.JOptionPane;

public class Menu {
	
	public static Produto prod;
	Funcionario func;
	Adm adm;
	private String codigo = "12345";
	static boolean prodFlag = false;
	static boolean funcFlag = false;
	
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
		int resp = JOptionPane.showOptionDialog(null, "Escolha uma opção para continuar", "Principal - Funcionário", 0, 1, null, opcoes, opcoes[0]);
		do {
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

}
