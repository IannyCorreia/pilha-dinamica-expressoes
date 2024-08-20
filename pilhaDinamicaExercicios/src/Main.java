import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a expressão a ser verificada:");
        String expressao = scanner.nextLine();
        VerificadorExpressoes verificação = new VerificadorExpressoes();
    
        if(verificação.verificaExpressao(expressao)) {
            System.out.println("A expressão está correta.");
        } else {
            System.out.println("A expressão está incorreta.");
        }
    
        scanner.close();
    }
}
