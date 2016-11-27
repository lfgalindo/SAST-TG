package br.com.sast.domain;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe definida para mapear a entidade "tb_planocliente" e seus atributos.
 *
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 30/08/2016
 */
@Entity
@Table(name = "tb_planocliente")
public class PlanoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;

    @ManyToOne
    @JoinColumn( nullable = false, unique = false)
    private Cliente codigoCliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, unique = false)
    private Plano codigoPlano;

    //GETS & SETS

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Cliente codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Plano getCodigoPlano() {
        return codigoPlano;
    }

    public void setCodigoPlano(Plano codigoPlano) {
        this.codigoPlano = codigoPlano;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.codigo;
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
        final PlanoCliente other = (PlanoCliente) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public String toString() {
        return "PlanoCliente [codigo= " + codigo + ", codigoCliente=" + codigoCliente + ", codigoPlano=" + codigoPlano
                + "]";
    }

}
