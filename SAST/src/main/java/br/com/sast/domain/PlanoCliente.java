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
    private Cliente codigoCliente_codigo;

    @ManyToOne
    @JoinColumn(nullable = false, unique = false)
    private Plano codigoPlano_codigo;

    //GETS & SETS
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public Cliente getCodigoCliente_codigo() {
        return codigoCliente_codigo;
    }

    public void setCodigoCliente_codigo(Cliente codigoCliente_codigo) {
        this.codigoCliente_codigo = codigoCliente_codigo;
    }

    public Plano getCodigoPlano_codigo() {
        return codigoPlano_codigo;
    }

    public void setCodigoPlano_codigo(Plano codigoPlano_codigo) {
        this.codigoPlano_codigo = codigoPlano_codigo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.codigo;
        hash = 23 * hash + Objects.hashCode(this.codigoCliente_codigo);
        hash = 23 * hash + Objects.hashCode(this.codigoPlano_codigo);
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
        if (!Objects.equals(this.codigoCliente_codigo, other.codigoCliente_codigo)) {
            return false;
        }
        if (!Objects.equals(this.codigoPlano_codigo, other.codigoPlano_codigo)) {
            return false;
        }
        return true;
    }
    
 
    
    @Override
    public String toString() {
        return "PlanoCliente [codigo= " + codigo + ", codigoCliente=" + codigoCliente_codigo + ", codigoPlano=" + codigoPlano_codigo
                + "]";
    }

}
