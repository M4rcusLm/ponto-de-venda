import javax.swing.JOptionPane;

public class Produto {

	// FINALIZADO
	
	private String nome;
	private double valor;
	private int quantidade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void cadastrarProduto() {
		
		boolean flag = true;
		do {
			
			String nome = JOptionPane.showInputDialog(null, "Informe o nome do produto:", "Cadastrando produto", JOptionPane.QUESTION_MESSAGE);
			if(nome == null) {
				break;
			}
			
			double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o preço do produto:", "Cadastrando produto", JOptionPane.QUESTION_MESSAGE).replace(",", "."));
			
			String estoque = JOptionPane.showInputDialog(null, "Informe a quantidade em estoque:", "Cadastrando produto", JOptionPane.QUESTION_MESSAGE);
			if(estoque == null) {
				break;
			}
			estoque.replaceAll("[^0-9]", "");
		
			if(!nome.isBlank() && valor != 0.0 && !estoque.isBlank()) {
				this.setNome(nome);
				this.setValor(valor);
				this.setQuantidade(Integer.parseInt(estoque));
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Cadastrando produto", JOptionPane.INFORMATION_MESSAGE);
				flag = false;
			} else {
				JOptionPane.showMessageDialog(null, "Você esqueceu de preencher algum campo.", "Erro ao cadastrar produto", JOptionPane.ERROR_MESSAGE);
			}
			
		} while(flag);
		
	}
	
	public void consultarProduto() {
		
		String[] opcoes = {"Alterar", "Voltar"};
		int resp;
		do {
			resp = JOptionPane.showOptionDialog(null, "Nome: " + this.getNome() + "\nValor: " + this.getValor() + "\nEstoque: " + this.getQuantidade(), "Dados do produto", 0, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[1]);
		
			switch(resp) {
			case 0:
				alterarProduto();
				break;
			case 1:
			
			default:
				resp = 1;
				break;
			}
		} while(resp != 1);
	
	}
	
	public void alterarProduto() {
		
		String[] opcoes = {"Nome", "Preço", "Estoque", "Voltar"};
		int resp = JOptionPane.showOptionDialog(null, "Escolha algum dado para alterar:", "Dados do funcionário", 0, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[3]);
		
		switch(resp) {
		case 0:
			String nome = JOptionPane.showInputDialog(null, "Novo nome:", "Alterando nome", JOptionPane.QUESTION_MESSAGE);
			if(nome != null) {
				this.setNome(nome);
			} else {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente.", "Erro ao alterar", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 1:
			String preco = JOptionPane.showInputDialog(null, "Novo preço:", "Alterando preço", JOptionPane.QUESTION_MESSAGE).replace(",", ".");
			if(preco != null) {
				this.setValor(Double.parseDouble(preco));
			} else {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente.", "Erro ao alterar", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 2:
			String estoque = JOptionPane.showInputDialog(null, "Nova quantidade em estoque:", "Alterando quantidade", JOptionPane.QUESTION_MESSAGE);
			if(estoque != null) {
				int quant = Integer.parseInt(estoque.replaceAll("[^0-9]", ""));
				this.setQuantidade(quant);
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
