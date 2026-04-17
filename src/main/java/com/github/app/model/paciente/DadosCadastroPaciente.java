package com.github.app.model.paciente;

import com.github.app.model.endereco.DadosCadastroEndereco;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//import com.github.app.model.endereco.DadosCadastroEndereco;

public record DadosCadastroPaciente(

    @NotBlank //verifica se o campo está preenchido -> só consegue utulizar em Strings
    String nome, 

    @Email //verifica se é um e-mail válido
    @NotBlank
    String email, 

    String telefone,

    String cpf, 

    @NotNull @Valid  //Valid ativa mecanismo de validação
    DadosCadastroEndereco endereco  //uma classe para endereço, pois são informações que irão se repetir também para pacientes
    ) {
    
}
