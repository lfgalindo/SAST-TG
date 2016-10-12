package br.com.sast.bean;

/*import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;*/

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

//import org.omnifaces.util.Faces;

import br.com.sast.dao.FuncionarioDAO;
import br.com.sast.domain.Funcionario;

/**
 * Classe definida para controlar a autenticação de Usuários
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 04/10/2016
 */
@ManagedBean
@SessionScoped
public class AutenticacaoBean {
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private Funcionario funcionario;
    private Funcionario funcionarioLogado;
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionarioLogado() {
        return funcionarioLogado;
    }

    public void setFuncionarioLogado(Funcionario funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
    }
       
    @PostConstruct
    public void iniciar() {
        funcionario = new Funcionario();
    }

    public void autenticar() {
        
       /* try {
            Faces.redirect("index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(AutenticacaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }

    
}
