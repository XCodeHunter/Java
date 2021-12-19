package poo.polimorfismo;

public class program {
    public static void main(String[] args) {
        funcionario f = new editorVideo("Gustavo", "12345678910", 1234);
        funcionario func = new gerente("Gustavi", "!11", 1234,2222); 

        ControleBonificacao controle = new ControleBonificacao();
        controle.registra(f);
        controle.registra(func);

        gerente g = new gerente("a", "a", 123, 2222);

        SistemaInterno si = new SistemaInterno();
        si.autentica(g);
    }
}
