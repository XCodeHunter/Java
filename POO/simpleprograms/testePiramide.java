package simpleprograms;

public class testePiramide {
    public static void main(String[] args) {
        
        for (int linha = 1; linha <= 10; linha++) {
            for (int coluna = 1; coluna <= linha; coluna++) {
                System.out.print("linha " + linha + " Coluna " + coluna + " = " + "*");
            }
            System.out.println();
        }
    }
}
