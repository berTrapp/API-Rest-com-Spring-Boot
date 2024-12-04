package com.bertrapp;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PrimeiroTeste {

    Calculadora calculadora;

    @BeforeEach
    public void setUp(){
        calculadora = new Calculadora();
    }

    @Test
    public void deveSomar2Numeros(){
        //cenario
        int numero1 = 10, numero2 = 5;

        //execução
        int resultado = calculadora.somar(numero1, numero2);

        //verificação
        Assertions.assertThat(resultado).isEqualTo(15);
    }

    @Test
    public void naoDeveSomarNumerosNegativos(){
        //cenario
        int numero1 = 10, numero2 = -4;

        //execução
        assertThatThrownBy(() -> calculadora.somar(numero1, numero2))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Não é permitido somar números negativos");

    }

    @Test
    public void deveSubtrair2Numeros(){
        //cenario
        int numero1 = 10, numero2 = 3;

        //execução
        int resultado = calculadora.subtrair(numero1, numero2);

        //verificação
        Assertions.assertThat(resultado).isEqualTo(7);
    }

    @Test
    public void deveMultiplicar2Numeros(){
        //cenario
        int numero1 = 9, numero2 = 4;

        //execução
        int resultado = calculadora.multiplicar(numero1, numero2);

        //verificação
        Assertions.assertThat(resultado).isEqualTo(36);
    }

    @Test
    public void deveDividir2Numeros(){
        //cenario
        int numero1 = 27, numero2 = 3;

        //execução
        float resultado = calculadora.dividir(numero1, numero2);

        //verificação
        Assertions.assertThat(resultado).isEqualTo(9);
    }

    @Test
    public void naoDeveDividirPor0(){
        //cenario
        int numero1 = 17, numero2 = 0;

        //execução
        assertThatThrownBy(() -> calculadora.dividir(numero1, numero2))
                .isInstanceOf(ArithmeticException.class);
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

    int subtrair(int num, int num2){
        return num - num2;
    }

    int multiplicar(int num, int num2){
        return num * num2;
    }

    float dividir(int num, int num2){
        return num / num2;

    }
}