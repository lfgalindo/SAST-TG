package br.com.sast.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Classe definida para mapear a entidade "tb_manutencao" e seus atributos.
 *
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 30/08/2016
 */
@Entity
@Table(name = "tb_manutencao")
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;

    @Column(length = 255, nullable = false)
    private String descricao;

    @Column(length = 255, nullable = false)
    private String descProblema;

    @Column(length = 255, nullable = true)
    private String observacoes;

    @Column(length = 15, nullable = false)
    private String prioridade;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAgendamento;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dtExecucao;

    @Column(nullable = false)
    private int baixa;

    @ManyToOne
    @JoinColumn(nullable = false, unique = false)
    private Cliente codigoCliente;

    @ManyToOne
    @JoinColumn(nullable = false, unique = false)
    private Funcionario codigoFuncionario;

    @Transient
    private String ManBaix;

    public String getBaixaMan() {

        if (baixa == 1) {
            ManBaix = "Sim";
        } else {
            ManBaix = "Não";
        }

        return ManBaix;
    }

    //GETS & SETS
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescProblema() {
        return descProblema;
    }

    public void setDescProblema(String descProblema) {
        this.descProblema = descProblema;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Date getDtAgendamento() {
        return dtAgendamento;
    }

    public void setDtAgendamento(Date dtAgendamento) {
        this.dtAgendamento = dtAgendamento;
    }

    public Date getDtExecucao() {
        return dtExecucao;
    }

    public void setDtExecucao(Date dtExecucao) {
        this.dtExecucao = dtExecucao;
    }

    public int getBaixa() {
        return baixa;
    }

    public void setBaixa(int baixa) {
        this.baixa = baixa;
    }

    public Cliente getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Cliente codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Funcionario getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(Funcionario codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Manutencao other = (Manutencao) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return "Manutencao [codigo= " + codigo + ", descricao=" + descricao + ", descProblema=" + descProblema
                + ", observacoes=" + observacoes + ", prioridade=" + prioridade + ", dtAgendamento=" + dtAgendamento
                + ", dtExecucao=" + dtExecucao + ", baixa=" + baixa + ", codigoCliente=" + codigoCliente
                + ", codigoFuncionario=" + codigoFuncionario + "]";
    }

}
