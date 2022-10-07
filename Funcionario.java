import javax.swing.JOptionPane;

public class Funcionario {

	private String nome, email, senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	// fim dos getters e setters
	
	public void cadastrarFuncionario() {
		
		boolean flag = true;
		do {
			
			String nome = JOptionPane.showInputDialog(null, "Informe o nome do funcionário:", "Cadastrando funcionário", JOptionPane.QUESTION_MESSAGE);
			if(nome == null) {
				break;
			}
			String email = JOptionPane.showInputDialog(null, "Informe um email do funcionário:", "Cadastrando funcionário", JOptionPane.QUESTION_MESSAGE);
			if(email == null) {
				break;
			}
			String senha = JOptionPane.showInputDialog(null, "Informe um senha do funcionário:", "Cadastrando funcionário", JOptionPane.QUESTION_MESSAGE);
			if(senha == null) {
				break;
			}
		
			if(!nome.isBlank() && !email.isBlank() && !senha.isBlank()) {
				this.setNome(nome);
				this.setEmail(email);
				this.setSenha(senha);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Cadastrando funcionário", JOptionPane.INFORMATION_MESSAGE);
				Menu.funcFlag = true;
				flag = false;
			} else {
				JOptionPane.showMessageDialog(null, "Você esqueceu de preencher algum campo.", "Erro ao cadastrar funcionário", JOptionPane.ERROR_MESSAGE);
			}
			
		} while(flag);
		
	}
	
	public void consultarFunc() {
		
		String[] opcoes = {"Alterar", "Voltar"};
		int resp;
		do {
			resp = JOptionPane.showOptionDialog(null, "Nome: " + this.getNome() + "\nLogin: " + this.getEmail() + "\nSenha: " + this.getSenha(), "Dados do funcionário", 0, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
		
			switch(resp) {
			case 0:
				alterarFunc();
				break;
			case 1:
			
			default:
				resp = 1;
				break;
			}
		} while(resp != 1);
		
	}

	public void alterarFunc() {
		
		String[] opcoes = {"Nome", "Login", "Senha", "Voltar"};
		int resp = JOptionPane.showOptionDialog(null, "Escolha algum dado para alterar:", "Dados do funcionário", 0, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[3]);
		
		switch(resp) {
		case 0:
			String nome = JOptionPane.showInputDialog(null, "Novo nome:", "Alterando nome", JOptionPane.QUESTION_MESSAGE);
			if(!nome.isBlank()) {
				this.setNome(nome);
			} else {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente.", "Erro ao alterar", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 1:
			String email = JOptionPane.showInputDialog(null, "Novo login:", "Alterando login", JOptionPane.QUESTION_MESSAGE);
			if(!email.isBlank()) {
				this.setEmail(email);
			} else {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente.", "Erro ao alterar", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 2:
			String senha = JOptionPane.showInputDialog(null, "Nova senha:", "Alterando senha", JOptionPane.QUESTION_MESSAGE);
			if(!senha.isBlank()) {
				this.setSenha(senha);
			} else {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente.", "Erro ao alterar", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 3:
			
		default:
			break;
		}
		
	}

	public void realizarVenda() {
		
		String search = JOptionPane.showInputDialog(null, "Pesquise por um produto", "Realizando venda", JOptionPane.QUESTION_MESSAGE);
		int qnt;
		Double total;
		if(search != null) {
			if(Menu.prod.getNome().equals(search)) {
				
				String quant = JOptionPane.showInputDialog(null, "Informe a quantidade desejada:", "Realizando venda", JOptionPane.QUESTION_MESSAGE);
				quant.replaceAll("[^0-9]", "");
				qnt = Integer.parseInt(quant);
				
				if(qnt <= Menu.prod.getQuantidade()) {
					total = qnt * Menu.prod.getValor();
					int confirm = JOptionPane.showConfirmDialog(null, "Valor a ser pago: R$" + Double.toString(total), "Confirmando venda", JOptionPane.INFORMATION_MESSAGE);
					
					if(confirm == 0) {
						Menu.prod.setQuantidade(Menu.prod.getQuantidade() - qnt);
						JOptionPane.showMessageDialog(null, "Venda realizada!");
					} else {
						JOptionPane.showMessageDialog(null, "Venda não realizada.");
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Estoque insuficiente", "Realizando venda", JOptionPane.WARNING_MESSAGE);
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Produto não encontrado.", "Realizando venda", JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}

}
