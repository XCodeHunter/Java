package newBank;

public class program {
    public static void main(String[] args) {
        gerente gere =  new gerente("Gustavo", "123.456.789-10", 1057.0, 1234);
        gere.autentica(123);
        System.out.println(gere.getBonificaco());
    }
}
