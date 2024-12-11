package com.bertrapp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CadastroPessoasTest {

    @Test
    public void deveCriarOCadastroDePessoas(){
        //Cenário
        CadastroPessoas cadastro = new CadastroPessoas();

        //Execução
        Assertions.assertThat(cadastro.getPessoas() ).isEmpty();
    }

    @Test
    public void deveAdicionarUmaPessoa(){
        //Cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //Execução
        cadastroPessoas.adicionar(pessoa);

        //Verificação
        Assertions
                .assertThat(cadastroPessoas.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }

    @Test
    public void naoDeveAdicionarPessoaComNomeVazio(){
        //Cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //Execução
        assertThatThrownBy(() -> VerificaPessoa.validaNome(pessoa))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Não é permitido adicionar uma pessoa com o nome vazio");
    }

    @Test
    public void deveRemoverUmaPessoa(){
        //Cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Bernardo");
        cadastroPessoas.adicionar(pessoa);

        //Execução
        cadastroPessoas.remover(pessoa);

        //Verificação
        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();
    }

    @Test
    public void naoDeveRemoverPessoaInexistente(){
        //Cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //Execução
        assertThatThrownBy(() -> cadastroPessoas.remover(pessoa))
                .isInstanceOf(PessoaNaoExiste.class);
    }
}
