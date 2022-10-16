import entity.NumerosAleatorio;
import service.GeradorNumerosAleatorios;

public class Principal {
    public static void main(String[] args) {
        GeradorNumerosAleatorios geradorNumerosAleatorios = new GeradorNumerosAleatorios();
        NumerosAleatorio numerosAleatorio = new NumerosAleatorio(4,9,4,7,10);
        var teste = geradorNumerosAleatorios.congruenteLinear(numerosAleatorio);

        System.out.println(teste.toString());
    }

}
