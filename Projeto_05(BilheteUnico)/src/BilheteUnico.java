import java.util.Random;

public class BilheteUnico {
	int numero;
	double saldo;
	static double valorPassagem = 4.40;
	Usuarios usuario;

	public BilheteUnico(String nome, String cpf, String tipo) {
		Random random = new Random();
		numero = random.nextInt(10000);
		saldo = 0;

		usuario = new Usuarios(nome, cpf, tipo);
	}

	public double consulta() {
		return saldo;
	}

	public void carregar(double valor) {
		saldo += valor;
	}

	public boolean catraca() {
		boolean aux = false;
		if (saldo >= valorPassagem) {
			if (usuario.tipo.equalsIgnoreCase("Normal")) {
				saldo -= valorPassagem;
				aux = true;
			} else {
				if (saldo >= valorPassagem / 2) {
					saldo -= (valorPassagem / 2);
					aux = true;
				}
			}
		}
		return aux;
	}
}
