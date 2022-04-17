package poo.cascoBank;

public class testReferences {
    public static void main(String[] args) {
        account primeiraConta = new account();
        primeiraConta.deposita(300.00);

        System.out.println("O saldo da primeira conta é: " + primeiraConta.getSaldo());

        account segundaConta = primeiraConta;
        System.out.println(segundaConta.getSaldo());
        
        segundaConta.deposita(100);

        System.out.println("O saldo da segunda conta é de: " + segundaConta.getSaldo());
        System.out.println("O saldo da primeira conta é de: " + primeiraConta.getSaldo());


        //Perceba que dessa forma que a variavel segundaConta recebeu o valor de primeira conta a varivel recebe o mesmo id local e o apontamento para o objeto é exatamente o mesmo
        System.out.println(primeiraConta);
        System.out.println(segundaConta);
    }  
}
