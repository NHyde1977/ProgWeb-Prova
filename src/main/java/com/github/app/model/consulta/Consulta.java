package com.github.app.model.consulta;
import com.github.app.model.paciente.Paciente;

import java.time.LocalDateTime;

import com.github.app.model.medico.Medico;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name="consultas")
public class Consulta{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "medicoId") // Define o nome da coluna "alias" na tabela consulta, ou seja,
    // pega  PK do médico e transforma em FK em consulta com o nome da coluna de medicoId.
    @ManyToOne
    private Integer medico;
    
    @JoinColumn(name = "pacienteId")
    @ManyToOne
    private Integer paciente;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String obervacao;

    private LocalDateTime data;

    //terceiro constructor da classe consulta que recebe a conversão que a classe DTO DadosAgendamentoConsulta está realizando. Json > OBJ(dict)

    public Consulta(DadosAgendamentoConsulta dados){
        this.medico = dados.medicoId();
        this.paciente = dados.pacienteId();
        this.status = dados.status();
        this.obervacao = dados.observacao();
        this.data = dados.data();
    }
}