package br.com.sast.util.validator;

import br.com.sast.util.TreatString;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    	 if (TreatString.isBlank(value.toString())) {
             return;
         }

        if ( !TreatString.isEmailValid(value.toString())) {
            throw new ValidatorException(new FacesMessage(
                FacesMessage.SEVERITY_WARN, "E-mail inválido.", null));
        }
    }

}