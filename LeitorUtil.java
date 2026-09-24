
import java.util.Scanner;
import java.util.function.Consumer;

public class LeitorUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static void lerEAtribuirInt(String mensagem, Consumer<Integer> setterAcao) {
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensagem);
                int valor = Integer.parseInt(scanner.nextLine());

                setterAcao.accept(valor);
                valido = true;

            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número inteiro válido.\n");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage() + "\n");
            }
        }
    }

    public static void lerEAtribuirStr(String mensagem, Consumer<String> setterAcao) {
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensagem);
                String valor = scanner.nextLine();

                setterAcao.accept(valor);
                valido = true;

            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage() + "\n");
            }
        }

    }

}
