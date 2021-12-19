package poo.polimorfismo;

public class gerente extends funcionario implements Autenticacao{

    private int senha;

    public gerente(String nome, String cpf, double salario, int senha) {
        super(nome, cpf, salario);
        this.senha = senha;
    }

    public double getBonificacao() {
        System.out.println("gerente");
        return super.getSalario();
    }

    @Override
    public boolean autentica(int senha) {
        if (this.senha == senha) {
            System.out.println("Usuario logado");
            return true;
        } else {
            System.out.println("Senha errada");
            return false;
        }
    }
}
