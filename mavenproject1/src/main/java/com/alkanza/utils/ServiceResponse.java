/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.utils;

import java.io.Serializable;

/**
 * Representacion de objeto para retorno, una vez consumida la API
 *
 * @author Teddy
 */
public class ServiceResponse implements Serializable {

    /**
     * Constante con codigo de transaccion exitosa
     */
    public static final int SUCCESS = 200;
    
    public static final int POST_SUCCESS = 201;

    /**
     * Constante con codigo de informacion faltante
     */
    public static final int MISSING_INFO = 400;

    /**
     * Constante con codigo para informar que no fue posible retornar
     * informacion
     */
    public static final int NOT_FOUND = 404;

    /**
     * Constante con codigo de error
     */
    public static final int ERROR = 500;

    int code;
    Object message;

    /**
     * Constructor de la clase ReturnOperation
     *
     * @param code
     * @param message
     */
    public ServiceResponse(int code, String message) {
        this.code = code;
        this.message = message;

    }

    /**
     * Constructor por defecto
     */
    public ServiceResponse() {
        this.code = ServiceResponse.SUCCESS;
        this.message = "OK";

    }

    /**
     *
     * @return
     */
    public int getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     *
     * @return
     */
    public Object getMessage() {
        return message;
    }

    /**
     *
     * @param message
     */
    public void setMessage(Object message) {
        this.message = message;
    }

}
