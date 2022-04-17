package simpleprograms;

public class TesteCondicional {
    public static void main(String[] args) {
        
        System.out.println("Vamos trabalhar com o primeiro IF");
        int idade = 20;
        int quantidadePessoas = 2;
        
        //Essa é um estrutura de if basica, verificando se a idade é maior ou igual a 18 anos
        //BOAS PRATICAS: INDEPENDENTE DA QUANTIDADE DE AÇÕES DO SEU IF USE CHAVES
        if (idade >= 18) {
            System.out.println("Idade maior que 18 anos");
            System.out.println("Seja bem vindo");
        }else if (quantidadePessoas > 0) {
            System.out.println("Voce esta acompanhado, pode entrar");
        }else{
            System.out.println("Infelizmente não pode entrar");
        }

    }
}
