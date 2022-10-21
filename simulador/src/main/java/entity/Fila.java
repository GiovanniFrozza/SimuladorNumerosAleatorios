package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fila {
    private int entradaA;//A
    private int entradaB;//B
    private int saidaA;//A
    private int saidaB;//B
    private int servidor;// C = numero de servidores
    private int capacidade;//K = capacidade da fila
    private int chegada; //Estado Inicial

    private int tamanho;//N = tamanho da populacao
    private int filaDeEspera;

    private List<Eventos> eventosList;

    /*
    *  G/G/2/3
    *  A/B/C/K
    */

    public int entradaClientes(){
        return this.getEntradaB() - this.getEntradaA();
    }

    public int saidaClientes(){
        return this.getSaidaB() - this.getSaidaA();
    }
}
