import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

public class Util {
	BilheteUnico[] bilhete = new BilheteUnico[5];
	int posicao = 0;

	public void menuPrincipal() {
		int opcao;

		do {
			opcao = parseInt(showInputDialog("Escolha uma opção:\n1. Administrador\n2. Usuário\n3. Finalizar"));
			if (opcao < 1 || opcao > 3) {
				showMessageDialog(null, "Opção Inválida!");
			} else if (opcao == 1) {
				menuAdministrador();
			} else if (opcao == 2) {
				menuUsuario();
			}
		} while (opcao != 3);
	}
	
	public void menuAdministrador() {
		int opcao;

		do {
			opcao = parseInt(showInputDialog("Escolha uma opção:\n1. Cadastrar bilhete\n2. Consultar bilhete\n3. Sair"));
			if (opcao < 1 || opcao > 3) {
				showMessageDialog(null, "Opção Inválida!");
			} else if (opcao == 1) {
				cadastroBilhete();
			}
		} while (opcao != 3);
	}
	
	public void menuUsuario() {
		int opcao;

		do {
			opcao = parseInt(showInputDialog("Escolha uma opção:\n1. Consultar saldo\n2. Carregar bilhete\n3. Passar na catraca\n4. Sair"));
			if (opcao < 1 || opcao > 4) {
				showMessageDialog(null, "Opção Inválida!");
			} else if (opcao == 1) {
				consultarSaldo();
			} else if (opcao == 2) {
				carregarBilhete();
			} else if (opcao == 3) {
				cobrarBilhete();
			}
		} while (opcao != 4);
	}

	public int pesquisar(String cpf) {
		int aux = -1;
		for (int i = 0; i < posicao; i++) {
			if (bilhete[i].usuario.cpf.equals(cpf)) {
				aux = i;
				break;
			}
		}
		return aux;
	}

	public void cadastroBilhete() {
		String nome, tipo, cpf;
		int indice;

		if (posicao >= bilhete.length) {
			showMessageDialog(null, "Sistema inoperante!");
		} else {
			cpf = showInputDialog("Digite o CPF: ");
			indice = pesquisar(cpf);
			if (indice == -1) {
				nome = showInputDialog("Digite o nome:");
				tipo = showInputDialog("Tipo (Estudante / Professor / Normal): ");
				bilhete[posicao] = new BilheteUnico(nome, cpf, tipo);
				posicao++;
			} else {
				showMessageDialog(null, "O CPF " + cpf + " já está cadastrado!");
			}
		}
	}

	public void consultarSaldo() {
		String cpf;
		int indice;

		cpf = showInputDialog("CPF");
		indice = pesquisar(cpf);
		if (indice == -1) {
			showMessageDialog(null, cpf + " não cadastrado");
		} else {
			showMessageDialog(null, "Saldo R$ " + bilhete[indice].consulta());
		}
	}
	
	public void carregarBilhete() {
		String cpf;
		int indice;
		double valor;

		cpf = showInputDialog("Digite o CPF");
		indice = pesquisar(cpf);
		if (indice == -1) {
			showMessageDialog(null, cpf + " não cadastrado");
		} else {
			valor = parseDouble(showInputDialog("Digite o valor: "));
			bilhete[indice].carregar(valor);
			showMessageDialog(null, "Bilhete carregado com sucesso!");
		}
	}
	
	private void cobrarBilhete() {
		String cpf;
		int indice;
		boolean catraca;

		cpf = showInputDialog("CPF");
		indice = pesquisar(cpf);
		if (indice == -1) {
			showMessageDialog(null, cpf + " não cadastrado");
		} else {
			catraca = bilhete[indice].catraca();
			if (catraca == true) {
				showMessageDialog(null, "Passagem autorizada!");
			} else {
				showMessageDialog(null, "Saldo insuficiente!");
			}
			
		}
	}	
		
	

}
