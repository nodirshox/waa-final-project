package uz.spiders.propertymanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Client data is not valid")
public class BadRequestException extends RuntimeException{

    public BadRequestException(String message) {
        super(message);
    }
}
