public class Servico {
    private String descricao;
    private String data;
    
    public Servico(String descricao, String data) {
        this.descricao = descricao;
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Serviço: " + descricao + ", Data: " + data;
    }
}
