package br.com.sast.domain;


import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe definida para mapear a entidade "tb_plano" e seus atributos.
 *
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 30/08/2016
 */
@Entity
@Table(name = "tb_plano")
public class Plano {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    @Column(length = 45, nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Integer velocidade;

    @Column(nullable = false)
    private Integer garantia;

    @Column(length = 45, nullable = false)
    private String tipoConexao;

    @Column(nullable = false)
    private Double valor;
    
    public Plano(){
        
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Integer velocidade) {
        this.velocidade = velocidade;
    }

    public Integer getGarantia() {
        return garantia;
    }

    public void setGarantia(Integer garantia) {
        this.garantia = garantia;
    }

    public String getTipoConexao() {
        return tipoConexao;
    }

    public void setTipoConexao(String tipoConexao) {
        this.tipoConexao = tipoConexao;
    }
    
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    public Double getValor() {
        return valor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.codigo);
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
        final Plano other = (Plano) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    public String toString() {
        return "Plano código: " + getCodigo() + ", tipo " + getTipoConexao();
    }
    
    
}
