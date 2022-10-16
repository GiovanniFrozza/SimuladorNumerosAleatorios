package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NumerosAleatorio {
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
}
