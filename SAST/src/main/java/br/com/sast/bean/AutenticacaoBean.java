package br.com.sast.bean;

import br.com.sast.dao.ClienteDAO;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.sast.dao.FuncionarioDAO;
import br.com.sast.domain.Cliente;
import br.com.sast.domain.Funcionario;
import br.com.sast.util.Util;
import javax.faces.application.FacesMessage;

/**
 * Classe definida para controlar a autenticação de Usuários
 * @author Luis Claudio Gonçalves Sanches <luis.cgs@hotmail.com.com>
 * @since 28/10/2016
 */

@ManagedBean(name="autenticacaoBean")
@SessionScoped
public class AutenticacaoBean implements Serializable{
	
    private static final long serialVersionUID = 6020394081393590995L;
    
    private static final String PAGINA_PRINCIPAL = "principal.xhtml";
    private static final String PAGINA_AUTENTICACAO = "autenticacao.xhtml";
    
    public Boolean isFuncionario;
    public Boolean isCliente;

    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private Funcionario funcionario;
    private Funcionario funcionarioLogado;
    
    private ClienteDAO clienteDAO = new ClienteDAO();
    private Cliente cliente;
    private Cliente clienteLogado;
    
    @PostConstruct
    public void iniciar() {
        setFuncionario(new Funcionario());
    }

    public void autenticar() {
        try {
           setClienteLogado(clienteDAO.autenticar(funcionario.getLogin(), funcionario.getSenha()));
           if(Util.isNotNull(getClienteLogado())){
               setIsCliente(Boolean.TRUE);
           }
           
           setFuncionarioLogado(funcionarioDAO.autenticar(funcionario.getLogin(), funcionario.getSenha()));
           if(Util.isNotNull(getFuncionarioLogado())){
               setIsFuncionario(Boolean.TRUE);
           }
           
           if(Util.isNull(getFuncionarioLogado()) && Util.isNull(getClienteLogado())){
               Messages.addGlobalWarn("Login ou Senha incorretos", FacesMessage.SEVERITY_WARN);
               return;
           }
           
           Faces.redirect(PAGINA_PRINCIPAL);
        } catch (IOException ex) {
            Logger.getLogger(AutenticacaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   public void logout(){
       //Faces.getSession().invalidate();
       
        try{
            
            Faces.redirect(PAGINA_AUTENTICACAO);
        } catch (IOException e){
            Messages.addGlobalError(e.getMessage());
        }
        
    }
  
   // Getters & Setters
    public Boolean getIsFuncionario() {
        return isFuncionario;
    }

    public void setIsFuncionario(Boolean isFuncionario) {
        this.isFuncionario = isFuncionario;
    }
    
    public Boolean getIsCliente() {
        return isCliente;
    }

    public void setIsCliente(Boolean isCliente) {
        this.isCliente = isCliente;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getClienteLogado() {
        return clienteLogado;
    }

    public void setClienteLogado(Cliente clienteLogado) {
        this.clienteLogado = clienteLogado;
    }
    
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
}
