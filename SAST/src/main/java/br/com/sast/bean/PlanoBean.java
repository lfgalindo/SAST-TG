package br.com.sast.bean;

/**
 * Classe definida para controlar a comunição entre a classe PlanoDAO e sua
 * Interface Web
 *
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since Classe criada em 25/10/2016
 */
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.sast.dao.PlanoDAO;
import br.com.sast.domain.Plano;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omnifaces.util.Faces;

@ManagedBean
@ViewScoped
public class PlanoBean {

    private Plano plano;
    private List<Plano> planos;
    private Integer codigo;
    
     public void novo() {

        plano = new Plano();

    }//fim do método novo
    
    //GETS & SETS
    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public List<Plano> getPlanos() {
        return planos;
    }

    public void setPlanos(List<Plano> planos) {
        this.planos = planos;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    //MÉTODOS CRUD
    //Método que prepara a tela para inserir novo registro

    //método para inserir um novo registro no banco
    public void salvar() {

        PlanoDAO planoDAO = new PlanoDAO();
        planoDAO.inserir(plano);

        Messages.addGlobalInfo("Plano inserido com sucesso!");

        novo();

    }//fim do método salvar

    //método para listar os registros do banco.
    public void listar() {

        PlanoDAO planoDAO = new PlanoDAO();
        planos = planoDAO.listar();

    }//fim do método listar

    //método para buscar um registro específico no banco.
    public void buscar() {

        PlanoDAO planoDAO = new PlanoDAO();
        plano = planoDAO.buscar(codigo);

    }//fim do método buscar

    //método para editr um registro específico no banco.
    public void editar() {

        PlanoDAO planoDAO = new PlanoDAO();
        planoDAO.editar(plano);

        Messages.addGlobalInfo("Plano editado com sucesso!");

    }//fim do método editar

    //método para excluir um registro específico no banco.
    public void excluir() {

        PlanoDAO planoDAO = new PlanoDAO();
        planoDAO.excluir(plano);

        Messages.addGlobalInfo("Plano excluído com sucesso!");

        try {
            Faces.redirect("planoListar.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(PerfilBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//fim do método excluir.
}
