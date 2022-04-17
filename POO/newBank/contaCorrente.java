package poo.newBank;

public class contaCorrente extends conta implements tributavel{

    public contaCorrente(int conta, int agencia, cliente titular) {
        super(conta, agencia, titular);
    }

    @Override
    public void sacar(double valor) {
        double valorSaque = valor + 0.20;
        if (valorSaque > valor) {
            super.sacar(valorSaque);
        }
    }

    @Override
    public double getValorImposto() {
        return super.getSaldo() * 0.01;
    }
    
}
