import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioManager {
    private ArrayList<Usuario> usuarios;
    private Scanner scanner;

    public UsuarioManager() {
        usuarios = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void cadastrarUsuario() {
        System.out.println("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.println("Sigite o email: ");
        String email = scanner.nextLine();
        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();

        Usuario novo = new Usuario(nome, email, senha);
        usuarios.add(novo);
        System.out.println("Usuário cadastrado com sucesso!\n");
    }

    // Método para realizar o login do usuário
    public void fazerLogin() {
        System.out.println("Digite o email: ");
        String email = scanner.nextLine();
        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();

        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                System.out.println("Bem vindo, " + u.getName() + "!\n");
                return;
            }
        }

        System.out.println("Email ou senha incorretos.\n");
    }

    // Menu Principal
    public void menu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("=== MENU ===");
            System.out.println("1. Cadastrar novo usuário");
            System.out.println("2. Fazer login");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    fazerLogin();
                break;
                case 0:
                    System.out.println("Encerrando o sistema....");
                    break;
                default:
                    System.out.println("opção inválida. Tente novamente");
            }
        }
    }
}
