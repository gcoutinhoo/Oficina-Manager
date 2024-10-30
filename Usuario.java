import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String telefone;
    private List<Servico> historicoServicos;

    public Usuario(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.historicoServicos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Servico> getHistoricoServicos() {
        return historicoServicos;
    }

    public void adicionarServico(Servico servico) {
        historicoServicos.add(servico);
    }

    public void exibirHistoricoServicos() {
        System.out.println("Histórico de serviços para " + nome + ":");
        for (Servico servico : historicoServicos) {
            System.out.println(servico);
        }
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone;
    }
}
