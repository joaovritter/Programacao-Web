package com.joaozaobala.empresajpa;

import jakarta.persistence.*;

/***
 * Tabela nova criada a partir do relacionamento Many to Many de Funcionario e Projeto
 * Armazena informações das duas tabelas:
 *  -@param
 *  -@param
 * @see EmbeddedId para puxar chave estranjeira composta de @deprecated FuncioanrioProjetoId, Como vai ser a chave primaria desta classe, utilizamos Embeded com Id
 */

@Entity
public class TrabalhaEm {
    @EmbeddedId
    private TrabalhaEmId id;

    @ManyToOne
    @MapsId ("funcionarioCpf") //pega cpfFuncionario(funcionario) e joga na funcioanrioCpf(FuncinarioCpfId)
    @JoinColumn (name = "Fcpf")
    private Funcionario cpfFuncionario;

    @ManyToOne
    @MapsId ("projetoId")
    @JoinColumn (name = "Pnr")
    private Projeto numeroProjeto;


}
