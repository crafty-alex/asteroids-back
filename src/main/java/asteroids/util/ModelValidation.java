package asteroids.util;

import asteroids.exception.BadRequestException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;


public class ModelValidation {

    private ModelValidation() {
    }


    public static void checkFields(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();

            if (bindingResult.getFieldErrors().isEmpty()) {
                for (ObjectError fieldError : bindingResult.getAllErrors()) {
                    sb.append("\n").append(fieldError.getDefaultMessage());
                }
            } else {
                for (FieldError fieldError : bindingResult.getFieldErrors()) {
                    sb.append("\n").append("champ : ").append(fieldError.getField()).append(", ").append(fieldError.getDefaultMessage()).append("\n").append("valeur rejetée : ").append(fieldError.getRejectedValue()).append("\n").append("\n");
                }
            }

            throw new BadRequestException("Bad request : " + sb);
        }
    }
}
