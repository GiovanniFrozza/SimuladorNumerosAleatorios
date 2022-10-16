public class Principal {
    public static void main(String[] args) {
        GeradorNumerosAleatorio geradorNumerosAleatorio = new GeradorNumerosAleatorio();
        var teste = geradorNumerosAleatorio.congruenteLinear(4, 9, 4, 7, 10);

        System.out.println(teste.toString());
    }

}
