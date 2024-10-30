import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mecanica {
    private List<Usuario> usuarios;

    public Mecanica() {
        this.usuarios = new ArrayList<>(); // Inicializando a lista de usuários
    }

    // Método para cadastrar um novo usuário
    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário " + usuario.getNome() + " cadastrado com sucesso.");
    }

    // Método para buscar um usuário pelo nome
    public Usuario buscarUsuario(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                return usuario;
            }
        }
        return null;
    }

    // Método para adicionar um serviço ao histórico de um usuário
    public void adicionarServicoAoUsuario(String nomeUsuario, Servico servico) {
        Usuario usuario = buscarUsuario(nomeUsuario);
        if (usuario != null) {
            usuario.adicionarServico(servico);
            System.out.println("Serviço '" + servico.getDescricao() + "' adicionado ao usuário " + nomeUsuario);
        } else {
            System.out.println("Usuário " + nomeUsuario + " não encontrado.");
        }
    }

    // Método para exibir o histórico de serviços de um usuário
    public void exibirHistorico(String nomeUsuario) {
        Usuario usuario = buscarUsuario(nomeUsuario);
        if (usuario != null) {
            usuario.exibirHistoricoServicos();
        } else {
            System.out.println("Usuário " + nomeUsuario + " não encontrado.");
        }
    }

    // Método principal para execução do programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mecanica mecanica = new Mecanica();

        while (true) {
            System.out.println("\nOlá! O que deseja fazer hoje?");
            System.out.println("1. Cadastrar novo usuário");
            System.out.println("2. Adicionar serviço ao usuário");
            System.out.println("3. Exibir histórico de serviços de um usuário");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    // Cadastro de novo usuário
                    System.out.print("Nome do usuário: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone do usuário: ");
                    String telefone = scanner.nextLine();
                    Usuario novoUsuario = new Usuario(nome, telefone);
                    mecanica.cadastrarUsuario(novoUsuario);
                    break;

                case 2:
                    // Adição de serviço a um usuário existente
                    System.out.print("Nome do usuário: ");
                    String nomeUsuario = scanner.nextLine();
                    System.out.print("Descrição do serviço: ");
                    String descricaoServico = scanner.nextLine();
                    System.out.print("Data do serviço (dd/MM/yyyy): ");
                    String dataServico = scanner.nextLine();
                    Servico novoServico = new Servico(descricaoServico, dataServico);
                    mecanica.adicionarServicoAoUsuario(nomeUsuario, novoServico);
                    break;

                case 3:
                    // Exibição do histórico de serviços de um usuário
                    System.out.print("Nome do usuário: ");
                    String nomeHist = scanner.nextLine();
                    mecanica.exibirHistorico(nomeHist);
                    break;

                case 4:
                    // Sair do programa
                    System.out.println("Muito obrigado, até a proxima!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Está opção não existe, tente outra opção.");
            }
        }
    }
}
