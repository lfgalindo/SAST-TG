package br.com.sast.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

//import org.omnifaces.util.Faces;

import br.com.sast.dao.FuncionarioDAO;
import br.com.sast.domain.Funcionario;

/**
 * Classe definida para controlar a autenticação de Usuários
 * @author Luis Claudio Gonçalves Sanches <luis.cgs@hotmail.com.com>
 * @since 28/10/2016
 */

@ManagedBean(name="autenticacaoBean")
@SessionScoped
public class AutenticacaoBean implements Serializable{
	
	private static final long serialVersionUID = 6020394081393590995L;
	
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
    	AutenticacaoBean autenticacaoBean = new AutenticacaoBean();
        setFuncionario(new Funcionario());
    }

    public void autenticar() {
        try {
        System.out.println("teste");
           Faces.redirect("index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(AutenticacaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   /* public void logout(){
        Faces.getSession().invalidate();
        try{
            Faces.redirect("autenticacao.xhtml");
        } catch (IOException e){
            Messages.addGlobalError(e.getMessage());
        }
    }*/
  
    
}
