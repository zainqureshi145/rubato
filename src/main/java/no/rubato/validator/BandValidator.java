package no.rubato.validator;

import no.rubato.model.Bands;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BandValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Bands.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Bands bands = (Bands) object;
        if(bands.getPassword().length() < 5){
            errors.rejectValue("password","length", "Password must be at least 6 characters long");
        }
        if(!bands.getPassword().equals(bands.getConfirmPassword())){
            errors.rejectValue("confirmPassword", "Match", "Password must match");
        }
    }
}
