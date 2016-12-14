package br.com.sast.bean;

import br.com.sast.dao.ClienteDAO;
import br.com.sast.dao.EmpresaDAO;
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

@ManagedBean
@SessionScoped
public class AutenticacaoBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private static final String PAGINA_PRINCIPAL = "principal.xhtml";
    private static final String PAGINA_AUTENTICACAO = "login.xhtml";
    
    public Boolean isFuncionario;
    public Boolean isCliente;
    public Boolean Empresa;
    
    private Integer gerenciarClientes;
    private Integer gerenciarFuncionarios;
    private Integer gerenciarCargos;
    private Integer gerenciarPlanos;
    private Integer gerenciarManutencoes;
    private Integer gerenciarPerfis;
    private Integer gerenciarConfiguracoes;

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
           
           EmpresaDAO empDAO = new EmpresaDAO();
           
           if(empDAO.contarRegistrosEmpresa() > 0){
               setEmpresa(Boolean.TRUE);
           }else{
               setEmpresa(Boolean.FALSE);
           }
           
           if(Util.isNotNull(getFuncionarioLogado())){
               setGerenciarCargos(getFuncionarioLogado().getCodigoPerfil().getGerenciarCargos());
               setGerenciarClientes(getFuncionarioLogado().getCodigoPerfil().getGerenciarClientes());
               setGerenciarConfiguracoes(getFuncionarioLogado().getCodigoPerfil().getGerenciarConfiguracoes());
               setGerenciarFuncionarios(getFuncionarioLogado().getCodigoPerfil().getGerenciarFuncionarios());
               setGerenciarManutencoes(getFuncionarioLogado().getCodigoPerfil().getGerenciarManutencoes());
               setGerenciarPerfis(getFuncionarioLogado().getCodigoPerfil().getGerenciarPerfis());
               setGerenciarPlanos(getFuncionarioLogado().getCodigoPerfil().getGerenciarPlanos());
           }
           
           Faces.setSessionAttribute(PAGINA_AUTENTICACAO, this);
           Faces.redirect(PAGINA_PRINCIPAL);
        } catch (IOException ex) {
            Logger.getLogger(AutenticacaoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   public void logout(){
       Faces.getSession().invalidate();
       Faces.setSessionAttribute("login.xhtml", null);
       
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

    public Boolean getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(Boolean Empresa) {
        this.Empresa = Empresa;
    }

    public Integer getGerenciarClientes() {
        return gerenciarClientes;
    }

    public void setGerenciarClientes(Integer gerenciarClientes) {
        this.gerenciarClientes = gerenciarClientes;
    }

    public Integer getGerenciarFuncionarios() {
        return gerenciarFuncionarios;
    }

    public void setGerenciarFuncionarios(Integer gerenciarFuncionarios) {
        this.gerenciarFuncionarios = gerenciarFuncionarios;
    }

    public Integer getGerenciarCargos() {
        return gerenciarCargos;
    }

    public void setGerenciarCargos(Integer gerenciarCargos) {
        this.gerenciarCargos = gerenciarCargos;
    }

    public Integer getGerenciarPlanos() {
        return gerenciarPlanos;
    }

    public void setGerenciarPlanos(Integer gerenciarPlanos) {
        this.gerenciarPlanos = gerenciarPlanos;
    }

    public Integer getGerenciarManutencoes() {
        return gerenciarManutencoes;
    }

    public void setGerenciarManutencoes(Integer gerenciarManutencoes) {
        this.gerenciarManutencoes = gerenciarManutencoes;
    }

    public Integer getGerenciarPerfis() {
        return gerenciarPerfis;
    }

    public void setGerenciarPerfis(Integer gerenciarPerfis) {
        this.gerenciarPerfis = gerenciarPerfis;
    }

    public Integer getGerenciarConfiguracoes() {
        return gerenciarConfiguracoes;
    }

    public void setGerenciarConfiguracoes(Integer gerenciarConfiguracoes) {
        this.gerenciarConfiguracoes = gerenciarConfiguracoes;
    }

    public FuncionarioDAO getFuncionarioDAO() {
        return funcionarioDAO;
    }

    public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    public void setClienteDAO(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }
    
    
}

