package poo.newBank;

public class calculadorImposto {
    
    private double totalImposto;

    public void registra(tributavel t){
        double valor = t.getValorImposto();
        this.totalImposto+=valor;
    }

    public double getImposto(){
        return totalImposto;
    }
}
