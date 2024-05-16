import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Conta implements IComunicable {
    private static int quantidade_contas; 
    protected Pessoa cliente;
    protected String agencia;
    protected String nConta;
    protected double saldo;
    protected String senha;
    protected int qtdTransacao;
    protected ArrayList<Transacao> transacoes = new ArrayList<>();

    public Conta(){

    }

    public void Enviar(){
        System.out.printf("%s estamos alertando sobre possível tentativa de login na sua conta, por favor, entre em contato conosco: 4002-8922\n", this.cliente.getNome());
    }

    public Conta(String nome, String cpf, String DDD, String telefone, String email, String nConta, String agencia, String senha) {
        quantidade_contas++;
        this.cliente = new Pessoa(nome, cpf, DDD, telefone, email);
        this.nConta = "" + quantidade_contas;
        this.agencia = agencia;
        this.senha = senha;
    }

    public String cpf(){
        return this.cliente.getCpf();
    }

    public String nome(){
        return this.cliente.getNome();
    }

    public void alterarNome(String nome){
        this.cliente.setNome(nome);
    }

    public static int getQuantidade_contas(){
        return quantidade_contas;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getAgencia(){
        return agencia;
    }

    public boolean valida_Logins(String Senha){
        if (this.senha.equals(Senha)) {
            return true;
        }
        return false;
    }

    public void deposito(double deposito) {
        this.saldo += deposito;
    }

    public void sacar(double saque) {
        this.saldo -= saque;
    }

    public String getnConta() {
        return nConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean validaSaldo(double valor){
        if (this.saldo >= valor) {
            return true;
        }
        return false;
    }

    public void pix(double valor, String emissor, Conta destinatario){
        this.sacar(valor);
        destinatario.deposito(valor);
        transacao(valor, emissor, destinatario.cliente.getNome(),  destinatario.transacoes);
        destinatario.qtdTransacao++;
    }

    public void transacao(double valor, String emissor, String destinatario, ArrayList<Transacao> destino){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        Transacao newTransacao = new Transacao(valor, destinatario, emissor, formato, destino);
        this.transacoes.add(newTransacao);
        this.qtdTransacao++;
    }

    public void getTransacoes(){
        for(int i = 0; i < qtdTransacao;i++){
            transacoes.get(i).getTransacao();
        }
    }

    public void imprimir() {
        System.out.printf("\n\nAgencia: %s\n", this.agencia);
        System.out.printf("Conta: %s\n", this.nConta);
        System.out.printf("Nome: %s\n", this.cliente.getNome());
        System.out.printf("Saldo: R$ %.2f\n", this.saldo);
        System.out.printf("CPF: %s\n\n", this.cliente.getCpf());
    }
}
