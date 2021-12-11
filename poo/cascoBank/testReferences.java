package poo.cascoBank;

public class testReferences {
    public static void main(String[] args) {
        account primeiraConta = new account();
        primeiraConta.saldoConta =  300.00;

        System.out.println("O saldo da primeira conta é: " + primeiraConta.saldoConta);

        account segundaConta = primeiraConta;
        System.out.println(segundaConta.saldoConta);
        
        segundaConta.saldoConta +=100;

        System.out.println("O saldo da segunda conta é de: " + segundaConta.saldoConta);
        System.out.println("O saldo da primeira conta é de: " + primeiraConta.saldoConta);


        //Perceba que dessa forma que a variavel segundaConta recebeu o valor de primeira conta a varivel recebe o mesmo id local e o apontamento para o objeto é exatamente o mesmo
        System.out.println(primeiraConta);
        System.out.println(segundaConta);
    }  
}
