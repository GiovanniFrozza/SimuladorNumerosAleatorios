import entity.*;
import service.GeradorNumerosAleatorios;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        GeradorNumerosAleatorios geradorNumerosAleatorios = new GeradorNumerosAleatorios();
        NumerosAleatorio numerosAleatorio = new NumerosAleatorio(4,9,4,7,10);
        var aleatoriosUtilizados = geradorNumerosAleatorios.congruenteLinear(numerosAleatorio);

        List<Evento> eventos = new ArrayList<>();
        Evento evento = new Evento(Prioridade.TEMPRIORIDADE, Status.CHEGADA);
        eventos.add(evento);
        Fila fila = new Fila(1,2,3,6,1,3,2.0, aleatoriosUtilizados, eventos);

        int contadorFilaAtual = 0;
        for(int i = 0; i < 10; i++){
            escalonador(fila, contadorFilaAtual, aleatoriosUtilizados);
        }

    }

    private static void escalonador(Fila fila, int contadorFilaAtual, List<Double> aleatoriosUtilizados) {
        if(fila.getEventos().get(0).getStatus().equals(Status.CHEGADA)){
            chegada(contadorFilaAtual, fila, aleatoriosUtilizados);
        } else {
            saida(fila, contadorFilaAtual, aleatoriosUtilizados);
        }
    }


    private static void chegada(int contadorFilaAtual, Fila fila, List<Double> aleatoriosUtilizados) {
        if(contadorFilaAtual < fila.getCapacidade()){
            contadorFilaAtual++;
            if(contadorFilaAtual <= fila.getServidor()){
                saida(fila, contadorFilaAtual, aleatoriosUtilizados);
            }
        }
        /*  U(A,B) = (B-A)xU(0,1) + A  */

        calcula(fila.entradaClientes(), aleatoriosUtilizados, contadorFilaAtual, fila.getEntradaA());

    }

    private static void saida(Fila fila, int contadorFilaAtual, List<Double> aleatoriosUtilizados) {
        LocalDateTime localAtual = LocalDateTime.now();
        contadorFilaAtual--;
        if(contadorFilaAtual >= fila.getServidor()){
            calcula(fila.saidaClientes(), aleatoriosUtilizados, contadorFilaAtual, fila.getSaidaA());
        }

    }

    private static void calcula(int fila, List<Double> aleatoriosUtilizados, int contadorFilaAtual, int fila1) {
        var resultadoChegada = (fila * aleatoriosUtilizados.get(contadorFilaAtual) ) + fila1;
        int passou = 0;
        passou++;

        System.out.println("p"+passou);
    }

}
