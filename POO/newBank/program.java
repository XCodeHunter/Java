package poo.newBank;

public class program {
    
    public static void main(String[] args) {
        cliente cli = new cliente("Gystav", "!qq", "Dev Jr.");

        contaCorrente cc = new contaCorrente(111, 22 , cli);
        cc.deposita(100);

        contaPoupanca cp = new contaPoupanca(111, 23, cli);
        cp.deposita(200);

        cc.transferir(100, cp);
        System.out.println("O saldo é de: " + cc.getSaldo());

        SeguroVida seguro = new SeguroVida();

        calculadorImposto calculador = new calculadorImposto();
        calculador.registra(seguro);

        System.out.println(calculador.getImposto());
    }
}
