package serie_fibonacci;

public class Serie {

	public static void main(String[] args) {
		int intNumero1 = 0;
		int intNumero2 = 1;
		int intSuma = 0;
		
		int intCantidadNumeros = 10;
		
		for(int x = 0; x <= intCantidadNumeros; x++) {
			intNumero1 = intNumero2;
			intNumero2 = intSuma;
			intSuma = intNumero1 + intNumero2;
			
			System.out.println(intNumero2);
		}
	}

}