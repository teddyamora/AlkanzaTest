/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Teddy
 */
public class AppUtils {

    public static void setGrowlInfo(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(severity,
                        summary,
                        detail));
    }

}
