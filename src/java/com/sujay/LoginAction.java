/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujay;

import de.schlichtherle.license.LicenseManager;
import de.schlichtherle.license.LicenseParam;
import de.schlichtherle.license.NoLicenseInstalledException;
import java.io.File;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author sujay
 */
public class LoginAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        LoginForm loginForm = (LoginForm)form;
        System.out.println(loginForm.getUserName() + ":" + loginForm.getPassword());

        return authenticate(mapping, loginForm.getUserName(), loginForm.getPassword());
    }

    public ActionForward authenticate(final ActionMapping mapping, final String userName, final String password) throws Exception {
        this.verifyLicense();

        if ("sample".equals(userName) && "password".equals(password)) {
            System.out.println("Success");
            return mapping.findForward(SUCCESS);
        } else {
            System.out.println("failure");
            return mapping.findForward(FAILURE);
        }
    }

    protected void verifyLicense() throws Exception {
        URL licenseUrl = getClass().getClassLoader().getResource("license.lic");
        String fileName = licenseUrl.getFile();
        if (licenseUrl == null) {
            throw new NoLicenseInstalledException("sample");
        } else {

            LicenseParam licenseParam = LicenseParamFactory.getLicenseParam();
            LicenseManager lm = new LicenseManager(licenseParam);
            lm.verify();
        }
    }
}
