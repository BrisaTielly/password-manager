import java.util.Base64;
import java.util.HashMap;
import java.util.Scanner;

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
    
    private static void mostrarMenu() {
        System.out.println("\n=== Gerenciador de Senhas ===");
        System.out.println("1. Adicionar nova senha");
        System.out.println("2. Buscar senha");
        System.out.println("3. Listar serviços");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarSenha() {
        System.out.print("Digite o nome do serviço: ");
        String servico = scanner.nextLine();
        
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();
        
        // Criptografia básica usando Base64
        String senhaCriptografada = Base64.getEncoder().encodeToString(senha.getBytes());
        senhas.put(servico, senhaCriptografada);
        
        System.out.println("Senha armazenada com sucesso!");
    }
    private static void buscarSenha() {
        System.out.print("Digite o nome do serviço: ");
        String servico = scanner.nextLine();
        
        if (senhas.containsKey(servico)) {
            String senhaCriptografada = senhas.get(servico);
            // Descriptografar a senha
            String senhaOriginal = new String(Base64.getDecoder().decode(senhaCriptografada));
            System.out.println("Senha: " + senhaOriginal);
        } else {
            System.out.println("Serviço não encontrado!");
        }
    }

    private static void listarServicos() {
        if (senhas.isEmpty()) {
            System.out.println("Nenhuma senha armazenada!");
            return;
        }

        System.out.println("\nServiços cadastrados:");
        for (String servico : senhas.keySet()) {
            System.out.println("- " + servico);
        }
    }
}
