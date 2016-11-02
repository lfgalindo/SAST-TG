
package br.com.sast.util;

import br.com.sast.bean.AutenticacaoBean;
import br.com.sast.domain.Funcionario;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.omnifaces.util.Faces;

@SuppressWarnings("serial")
public class AutenticacaoListener implements PhaseListener{
    
    private static final String PAGINA_AUTENTICACAO = "login.xhtml";

    @Override
    public void afterPhase(PhaseEvent pe) {
       String paginaAtual = Faces.getViewId();
        
       boolean paginaDeAutenticacao = paginaAtual.contains(PAGINA_AUTENTICACAO);
       
       if(!paginaDeAutenticacao){
           AutenticacaoBean autenticacaoBean = Faces.getSessionAttribute(PAGINA_AUTENTICACAO);
           
           if(autenticacaoBean == null){
               Faces.navigate(PAGINA_AUTENTICACAO);
               return;
           }
           Funcionario funcionario = autenticacaoBean.getFuncionarioLogado();
           if(funcionario == null){
               Faces.navigate(PAGINA_AUTENTICACAO);
               return;
           }
       }
    }

    @Override
    public void beforePhase(PhaseEvent pe) {
        System.out.println("Antes da fase: " + pe.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
}
