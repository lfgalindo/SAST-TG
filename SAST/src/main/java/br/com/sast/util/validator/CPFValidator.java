package br.com.sast.util.validator;

import br.com.sast.util.TreatString;
import br.com.sast.util.Util;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.apache.commons.lang.StringUtils;

@FacesValidator("cpfValidator")
public class CPFValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    	 if (StringUtils.isBlank(TreatString.filterOnlyNumber(value))) {
             return;
         }

        if ( !Util.isCPFValid(value.toString())) {
            throw new ValidatorException(new FacesMessage(
                FacesMessage.SEVERITY_WARN, "CPF inválido.", null));
        }
    }

}