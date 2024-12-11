package com.bertrapp;

public class VerificaPessoa {
    public static void validaNome(Pessoa pessoa) {
        if (pessoa.getNome() == null) {
            throw new RuntimeException("Não é permitido adicionar uma pessoa com o nome vazio");
        }
    }
}
