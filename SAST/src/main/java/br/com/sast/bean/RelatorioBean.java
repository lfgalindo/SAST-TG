
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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

@ManagedBean
@ViewScoped
public class RelatorioBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private static final String PAGINA_PRINCIPAL = "principal.xhtml";
    
    private List<Cliente> listaClientes;
    private List<Funcionario> listaFuncionarios;
    
    
    private String cidade;
    private String cliente;
    private String funcionario;
    private Date dataAgendamento;
    
    public void novo(){
        ClienteDAO clienteDAO = new ClienteDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        
        setListaClientes(clienteDAO.listar());
        setListaFuncionarios(funcionarioDAO.listar());
        setCidade("");
        setCliente("");
        setFuncionario("");
    }
    
    public void imprimir() throws IOException{
       try{
            String caminho = Faces.getRealPath("/relatorios/jasper/Manutencoes.jasper");
            Map<String, Object> parametros = new HashMap();
            
            if(Util.isNotNull(getCliente())){
                parametros.put("MANUTENCAO_CLIENTE", "%" + getCliente() + "%");
            } else {
                parametros.put("MANUTENCAO_CLIENTE", "%%");
            }
            
            if(Util.isNotNull(getFuncionario())){
                parametros.put("MANUTENCAO_FUNCIONARIO","%" + getFuncionario()+ "%");
            } else {
                parametros.put("MANUTENCAO_FUNCIONARIO", "%%");
            }
            
            if(Util.isNotBlank(getCidade())){
                parametros.put("MANUTENCAO_CIDADE","%" + getCidade() + "%");
            } else {
                parametros.put("MANUTENCAO_CIDADE", "%%");
            }
            
            System.out.println(parametros.toString());
            
            Connection conexao = HibernateUtil.getConexao();

            JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
            JasperPrintManager.printReport(relatorio, true);
            
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }
    
    
}
