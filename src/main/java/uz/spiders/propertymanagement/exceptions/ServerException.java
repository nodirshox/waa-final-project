package uz.spiders.propertymanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Server could not handle unknown error.")
public class ServerException extends RuntimeException{

    public ServerException(String message) {
        super(message);
    }
}
