import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Usuarios usuario = new Usuarios(null, null, null);
		BilheteUnico bilhete1 = new BilheteUnico(null, null, null);
		BilheteUnico bilhete2 = new BilheteUnico(null, null, null);
		Util util = new Util();
		
		util.menuPrincipal();
		
	}

}
