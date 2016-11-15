
package br.com.sast.bean;

import br.com.sast.dao.ClienteDAO;
import br.com.sast.dao.FuncionarioDAO;
import br.com.sast.domain.Cliente;
import br.com.sast.domain.Funcionario;
import br.com.sast.util.HibernateUtil;
import br.com.sast.util.Util;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

@ManagedBean
@ViewScoped
public class RelatorioBean {
    
    private static final String PAGINA_PRINCIPAL = "principal.xhtml";
    
    private List<Cliente> listaClientes;
    private List<Funcionario> listaFuncionarios;
    
    private Cliente cliente;
    private Funcionario funcionario;
    private Date dataAgendamento;
    
    public void novo(){
        ClienteDAO clienteDAO = new ClienteDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        
        listaClientes = clienteDAO.listar();
        listaFuncionarios = funcionarioDAO.listar();
        
        cliente = new Cliente();
        funcionario = new Funcionario();
    }
    
    public void imprimir() throws IOException{
       try{
            String caminho = Faces.getRealPath("/relatorios/jasper/Manutencoes.jasper");
            Map<String, Object> parametros = new HashMap();
            
            if(Util.isNotNull(getCliente().getNome())){
                parametros.put("MANUTENCAO_CLIENTE", "%" + this.cliente + "%");
            } else {
                parametros.put("MANUTENCAO_CLIENTE", "%%");
            }
            
            if(Util.isNotNull(getFuncionario().getNome())){
                parametros.put("MANUTENCAO_FUNCIONARIO","%" + getFuncionario() + "%");
            } else {
                parametros.put("MANUTENCAO_FUNCIONARIO", "%%");
            }
            
            if(Util.isNotBlank(getCliente().getCidade())){
                parametros.put("MANUTENCAO_CIDADE","%" + getCliente().getCidade() + "%");
            } else {
                parametros.put("MANUTENCAO_CIDADE", "%%");
            }
            
            System.out.println(parametros.toString());
            
            Connection conexao = HibernateUtil.getConexao();

            JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
            JasperPrintManager.printReport(relatorio, true);
            
            Messages.addGlobalInfo("Relatório gerado com sucesso!");
        } catch (JRException erro) {
            Messages.addGlobalError("Ocorreu um erro na geração do relatório ");
            erro.printStackTrace();
        }
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
