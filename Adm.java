import javax.swing.JOptionPane;

public class Adm extends Funcionario {

	public void consultarAdm() {
		
		String[] opcoes = {"Alterar", "Voltar"};
		int resp;
		do {
			resp = JOptionPane.showOptionDialog(null, "Nome: " + this.getNome() + "\nLogin: " + this.getEmail() + "\nSenha: " + this.getSenha(), "Dados do adm", 0, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
		
			switch(resp) {
			case 0:
				alterarAdm();
				break;
			case 1:
			
			default:
				resp = 1;
				break;
			}
		} while(resp != 1);
		
	}
	
	public void alterarAdm() {
		
		String[] opcoes = {"Nome", "Login", "Senha", "Voltar"};
		int resp = JOptionPane.showOptionDialog(null, "Escolha algum dado para alterar:", "Dados do adm", 0, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[3]);
		
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
	
}
