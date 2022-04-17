package simpleprograms;


public class testaCaracterer{
    public static void main(String[] args) {
        //Iniciando uma variavel com tipo char, necessario setar com aspas simples
        char  letra = 'a';
        //Imprimindo a variavel 
        System.out.println(letra);

        //O char é uma variavel do tipo numerica tambem, logo aceita valores numericos como no exemplo abaixo
        char valor = 66;
        System.out.println(valor);

        //Iremos trabalhar novamente com o casting para fixar
        //Vamos realizar uma operação matematica somando o valor + 1, dessa forma daria erro pois o numero 1
        // é um inteiro e no char não cabe um inteiro e se fosse vice-versa seria possivel realizar essa transação
        valor = (char) (valor +1);
        System.out.println(valor);

        // ###############################################################

        // Aprendendo String
        //Iniciando uma variavel do tipo String, como podemos ver necessario o usa de aspas composta
        String palavra = "Hebert";
        System.out.println(palavra);

        //Trabalhando com concatenação
        String junta = " Richard";

        System.out.println("Concatenação: " + palavra + junta);
        
    }
}