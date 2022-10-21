import entity.Eventos;
import entity.Fila;
import entity.NumerosAleatorio;
import entity.Status;
import service.GeradorNumerosAleatorios;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        GeradorNumerosAleatorios geradorNumerosAleatorios = new GeradorNumerosAleatorios();
        NumerosAleatorio numerosAleatorio = new NumerosAleatorio(4,9,4,7,10);
        var aleatoriosUtilizados = geradorNumerosAleatorios.congruenteLinear(numerosAleatorio);

        /* G/G/1/3 */
        /*  U(A,B) = (B-A)xU(0,1) + A  */
        Eventos eventos = new Eventos();
        Fila fila = new Fila();
        fila.setEntradaA(1);
        fila.setEntradaB(2);
        fila.setSaidaA(3);
        fila.setSaidaB(6);
        fila.setCapacidade(3);

        int contadorFilaAtual = 0;

        chegada(aleatoriosUtilizados, contadorFilaAtual, fila, eventos);


    }

    private static void chegada(List<Double> aleatoriosUtilizados, int contadorFilaAtual, Fila fila, Eventos eventos) {
        if(fila.getCapacidade() < 3){
            LocalDateTime localAtual = LocalDateTime.now();
            eventos.setStatus(Status.CHEGADA);
            contadorFilaAtual++;
            if(contadorFilaAtual <= 1){
                saida(aleatoriosUtilizados, fila, eventos, contadorFilaAtual);
            }
        }
        /*  U(A,B) = (B-A)xU(0,1) + A  */

        var resultadoChegada = (fila.entradaClientes() * aleatoriosUtilizados.get(contadorFilaAtual) ) + fila.getEntradaA();
        System.out.println(resultadoChegada);

    }

    private static void saida(List<Double> aleatoriosUtilizados, Fila fila, Eventos eventos, int contadorFilaAtual) {
        eventos.setStatus(Status.SAIDA);
        LocalDateTime localAtual = LocalDateTime.now();
        contadorFilaAtual--;
        if(contadorFilaAtual >= 1){
            var resultadoSaida = (fila.saidaClientes() * aleatoriosUtilizados.get(contadorFilaAtual) ) + fila.getSaidaA();
            System.out.println(resultadoSaida);
        }

    }

}
