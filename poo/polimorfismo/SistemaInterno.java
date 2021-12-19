package poo.polimorfismo;

public  class SistemaInterno {
    
    private int senha = 2222;

    public void autentica(Autenticacao g ){
        g.autentica(this.senha);
    }


}
