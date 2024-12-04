package com.bertrapp;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
public class PrimeiroTeste {

    @Test
    public void deveSomar2Numeros(){
        //cenario
        int numero1 = 10, numero2 = 5;

        //execução
        int resultado = numero1 + numero2;

        //verificação
        Assertions.assertThat(resultado).isEqualTo(15);
    }
}
