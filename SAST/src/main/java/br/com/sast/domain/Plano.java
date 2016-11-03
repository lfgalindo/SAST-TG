package br.com.sast.domain;


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

    public String toString() {
        return "Plano código: " + getCodigo() + ", tipo " + getTipoConexao();
    }
    
    
}
