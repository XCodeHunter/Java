package poo.cascoBank;

public class account {
    
    client titular;
    int numeroConta;
    int agencia;
    Double saldoConta;  


    public void deposita(double valor){
        saldoConta += valor;
    }

    public void sacar(double valor){
        if (saldoConta >= valor) {            
            saldoConta -= valor;
        }else {
            System.out.println("Valor insuficiente");
        }
    }

    public void transferir(double valor, account destino){
        if (this.saldoConta >= valor) {
            this.sacar(valor);
            destino.deposita(valor);
            System.out.println("Transferencia executada com sucesso!!");
        }else{
            System.out.println("Saldo insuficiente");
        }
    }
}
