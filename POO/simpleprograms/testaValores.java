package simpleprograms;

public class testaValores {
    public static void main(String[] args) {

        //Inicialização de duas variaveis do tipo primitivo
        int primeiro = 1;
        int segundo = 2;

        //Vamos atribuir o primeiro numero no segundo?
        segundo = primeiro;
        //Agora vamos atribuir um valor pro primeiro apos o segundo receber ele? 
        primeiro = 4;

        //Qual é o valor da segunda variavel?
        System.out.println(segundo);

        //Show de bola, vimos que o valor que era 2, recebeu o valor da primeira variavel e se tornou o numero 1
        //E independente do valor primeiro virar 4 a variavel segundo continuou com o valor 1. 
        
    }
}
