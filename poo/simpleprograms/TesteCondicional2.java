package simpleprograms;

public class TesteCondicional2 {
    public static void main(String[] args) {
        int idade = 20;
        int quantidadePessoas = 2;

        //Iremos melhorar a condição do exercicio anterior apresentando o operadorador logico
        if (idade >= 18 || quantidadePessoas > 1) {
            System.out.println("Bem vindo");
        }else{
            System.out.println("Nao pode entrar");
        }


        //Trabalhando com boolean
        String genero = "Masculino";
        boolean sexo = genero != "Feminino";

        if (sexo) {
            System.out.println("Você é Homem");
        }
    }
}
