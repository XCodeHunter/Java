package poo.cascoBank;

public class program {
   public static void main(String[] args) {
       account contaGustavo = new account();
       contaGustavo.saldoConta = 100.00;
       
       client infTitular =  new client();
       infTitular.nome = "Gustavo";
       infTitular.cpf = "123.456.789-10";
       infTitular.profissao = "Dev Jr";

       contaGustavo.titular = infTitular;
       
       account contaCasco = new account();
       contaCasco.saldoConta = 100.00;
       
       contaGustavo.transferir(30.00, contaCasco);
       System.out.println("O saldo atual da conta origem é de: " + contaGustavo.saldoConta);
       System.out.println("O saldo atual da conta destino é de: " + contaCasco.saldoConta);

   } 
}
