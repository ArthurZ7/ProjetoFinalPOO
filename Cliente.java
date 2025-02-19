import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private int idade;
    private String endereco;
    
    public Cliente() {
    }

    public Cliente(String nome, String cpf, int idade, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.idade = idade;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public static void dados(List<Cliente> clientes, String cpf) {
        for (Cliente busca : clientes) {
            if (busca.getCpf().equals(cpf)) {
                System.out.println("Cliente:\nNome: " + busca.getNome() + "\nEndereço: " + busca.getEndereco() +
                                   "\nCPF: " + busca.getCpf() + "\nIdade: " + busca.getIdade());
            }
        }
    }
}
