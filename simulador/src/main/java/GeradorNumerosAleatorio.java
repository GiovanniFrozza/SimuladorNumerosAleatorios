import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GeradorNumerosAleatorio {
    /*metodo Congruente Linear.
    inteiro A
    inteiro M
    inteiro C
    sementeX0(valor inicial)
     */
    private int a;
    private int m;
    private int c;
    private int tamanho;
    private double sementeX0;

    public List<Double> congruenteLinear(int a, int m, int c, double sementeX0, int tamanho) {
        List<Double> resultadoList = new ArrayList<>();
        for (int i = 0; i < tamanho; i++) {
            double resultado = ((a * sementeX0) + c) % m;
            sementeX0 = resultado;
            resultadoList.add(resultado);
        }
        return resultadoList;
    }
}
