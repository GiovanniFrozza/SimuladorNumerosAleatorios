package service;

import entity.NumerosAleatorio;

import java.util.ArrayList;
import java.util.List;

public class GeradorNumerosAleatorios {
    public List<Double> congruenteLinear(NumerosAleatorio numerosAleatorio) {

        List<Double> resultadoList = new ArrayList<>();
        for (int i = 0; i < numerosAleatorio.getTamanho(); i++) {
            double resultado = ((numerosAleatorio.getA() * numerosAleatorio.getSementeX0()) + numerosAleatorio.getC()) % numerosAleatorio.getM();
            numerosAleatorio.setSementeX0(resultado);
            resultadoList.add(resultado);
        }
        return resultadoList;
    }

}
