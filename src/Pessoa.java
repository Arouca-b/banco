
public class Pessoa {
    public String nome;
    protected String cpf;
    protected String ddd;
    protected String telefone;
    protected String email;

    Pessoa(){};
    
    Pessoa(String nome, String cpf, String ddd, String telefone, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.ddd = ddd;
        this.telefone = telefone;
        this.email = email;
    }

    public String getCpf(){
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
