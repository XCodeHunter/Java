package newBank;

public class gerente extends funcionario{

    private int senha;

    public gerente(String nome, String cpf, double salario, int senha) {
        super(nome, cpf, salario);
        this.senha = senha;
    }

    public boolean autentica(int senha){
        if (this.senha == senha) {
            System.out.println("Usuario logado");
            return true;
        }else {
            System.out.println("Senha errada");
            return false;
        }
    }

    public double getBonificaco(){
        return super.getSalario() + super.getBonificacao();
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
}
