package ostrand.wigellcarrental.advice;

import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ostrand.wigellcarrental.controllers.CustomerController;
import ostrand.wigellcarrental.custom.exception.BusinessException;
import ostrand.wigellcarrental.custom.exception.ErrorResponse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

@ControllerAdvice
public class adviceController {
    private static final Logger adviceLogger = Logger.getLogger(CustomerController.class);
    private final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(BusinessException exc){
        ErrorResponse response = new ErrorResponse(exc.getStatus(),exc.getMessage(),getTimeStamp());
        adviceLogger.error("Error-response with following message: " + response.getMessage());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.resolve(response.getStatus()));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(DataIntegrityViolationException exc){
        exc.printStackTrace();
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "one or more fields have an incorrect value or is null, please check input data",getTimeStamp());
        adviceLogger.error("one or more fields have an incorrect value or is null, please check input data");
        return new ResponseEntity<ErrorResponse>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(NoSuchElementException exc){
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Not object found with id, Enter correct id:",getTimeStamp());
        adviceLogger.error("Not object found with provied id");
        return new ResponseEntity<ErrorResponse>(response,HttpStatus.NOT_FOUND);
    }




    private String getTimeStamp(){
        return FORMATTER.format(new Date(System.currentTimeMillis()));
    }
}
