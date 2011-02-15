/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujay;

import de.schlichtherle.license.LicenseContentException;
import de.schlichtherle.license.NoLicenseInstalledException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

/**
 *
 * @author sujay
 */
public class CustomExceptionHandler extends ExceptionHandler {

    @Override
    public ActionForward execute(Exception ex, ExceptionConfig ae, ActionMapping mapping, ActionForm formInstance, HttpServletRequest request, HttpServletResponse response) throws ServletException {
        System.out.println(getClass().getName());
        if (ex instanceof NoLicenseInstalledException) {
            request.setAttribute("installFailed", "No License Found");
            
        }
        if(ex instanceof LicenseContentException){
            request.setAttribute("installFailed", "License Not Valid");
        }
        return super.execute(ex, ae, mapping, formInstance, request, response);

    }
}
