import java.util.HashMap;
import java.util.Scanner;
import java.util.Base64;

public class GerenciadorSenhas {
    private static HashMap<String, String> senhas = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean executando = true;

        while (executando) {
            mostrarMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    adicionarSenha();
                    break;
                case 2:
                    buscarSenha();
                    break;
                case 3:
                    listarServicos();
                    break;
                case 4:
                    executando = false;
                    System.out.println("Programa finalizado!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}