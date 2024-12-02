package lk.ijse.cropmonitoringsystembackend.customObj;

import org.springframework.validation.FieldError;

import java.io.Serializable;

public class FieldErrorResponse implements Serializable, FieldResponse {

    private int errorCode;
    private String errorMessage;
}
