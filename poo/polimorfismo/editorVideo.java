package poo.polimorfismo;

public class editorVideo extends funcionario{

    public editorVideo(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }
    
    public double getBonificacao(){
        System.out.println("Editor");
        return 100;
    }
}
