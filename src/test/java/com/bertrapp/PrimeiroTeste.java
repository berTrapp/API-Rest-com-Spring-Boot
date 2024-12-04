package com.bertrapp;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PrimeiroTeste {

    @Test
    public void deveSomar2Numeros(){
        //cenario
        Calculadora calculadora = new Calculadora();
        int numero1 = 10, numero2 = 5;

        //execução
        int resultado = calculadora.somar(numero1, numero2);

        //verificação
        Assertions.assertThat(resultado).isEqualTo(15);
    }

    @Test
    public void naoDeveSomarNumerosNegativos(){
        //cenario
        Calculadora calculadora = new Calculadora();
        int numero1 = 10, numero2 = -4;

        //execução
        assertThatThrownBy(() -> calculadora.somar(numero1, numero2))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Não é permitido somar números negativos");

    }
}

class Calculadora {
    int somar(int num, int num2){
        if (num < 0 || num2 < 0){
            throw new RuntimeException("Não é permitido somar números negativos");
        }else {
            return num + num2;
        }
    }
}