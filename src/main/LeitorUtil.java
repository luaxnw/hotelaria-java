import java.util.Scanner;
import java.util.function.Consumer;

public class LeitorUtil {
    private static final Scanner scanner = new Scanner(System.in);

    // Método genérico quepede um inteiro e repete até o setter aceitar
    public static void lerEAtribuir(String mensagem, Consumer<Integer> setterAcao) {
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensagem);
                int valor = Integer.parseInt(scanner.nextLine()); // Evita problemas com buffer do scanner
                
                setterAcao.accept(valor); // Executa o setter da sua classe
                valido = true;            // Se não lançou exceção, deu certo e sai do loop
                
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número inteiro válido.\n");
            } catch (IllegalArgumentException e) {
                // Captura a exceção que veio direto do seu setter (ex: código <= 0)
                System.out.println("Erro: " + e.getMessage() + "\n");
            }
        }
    }
}
