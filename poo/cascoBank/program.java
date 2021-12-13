package poo.cascoBank;

public class program {
   public static void main(String[] args) {
       
       client infTitular =  new client("Gustavo","123.456.789-10","Dev Jr");

       account contaGustavo = new account(1234, 123, infTitular);
       contaGustavo.deposita(100.00);
       contaGustavo.setTitular(infTitular);
       
       account contaCasco = new account();
    
       contaGustavo.transferir(30.00, contaCasco);
       
       //Verificando se a transferencia foi realizado conferindo a conta de ambos os envolvidos
       System.out.println(contaGustavo.getSaldo());
       System.out.println(contaCasco.getSaldo());

       System.out.println("O total de contas criadas é de: " + account.getTotal());

   } 
}
