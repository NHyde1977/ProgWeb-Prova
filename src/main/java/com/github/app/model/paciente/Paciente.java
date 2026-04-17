package com.github.app.model.paciente;

import com.github.app.model.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Boolean ativo = true;

    @Embedded
    private Endereco endereco;

    //Constructor
    public Paciente(DadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.email = dados.email();
        this.telefone = dados.telefone();
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        // Verifica se o nome recebido é diferente de null, ou seja, se o nome foi enviado na requisição da atualização (PUT), e se for diferente de null, atualiza o nome do médico com novo nome recebido
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.email() != null) {
            this.email = dados.email();
        }
        if(dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void exclusaoLogica() {
        this.ativo = false;
    }

}
