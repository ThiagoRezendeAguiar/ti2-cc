import java.util.Scanner;

class SomarDoisNumeros {
  public static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
	 // Declaração e leitura de variáveis
	 System.out.print("Digite um número: ");
	 int num1 = sc.nextInt();
	 System.out.print("Digite outro número: ");
	 int num2 = sc.nextInt();
	 
	 // Calcular 
	 int soma = num1 + num2;
	 
	 // Exibir resultado
	 System.out.println("Soma: " + soma);
  }
}