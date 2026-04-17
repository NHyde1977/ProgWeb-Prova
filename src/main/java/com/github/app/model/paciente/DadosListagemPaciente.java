package com.github.app.model.paciente;

import com.github.app.model.endereco.Endereco;

public record DadosListagemPaciente(
    Integer id,
    String nome,
    String email,
    String cpf,
    Endereco endereco
) {
   
    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getEndereco());
    }
    
}