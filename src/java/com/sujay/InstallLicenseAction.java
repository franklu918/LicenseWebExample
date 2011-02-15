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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 *
 * @author sujay
 */
public class InstallLicenseAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

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
        URL licenseUrl = getClass().getClassLoader().getResource("license.lic");
        String fileName = licenseUrl.getFile();
        if (licenseUrl == null) {
            throw new NoLicenseInstalledException("License file not found.");
        }
        LicenseParam licenseParam = LicenseParamFactory.getLicenseParam();
        LicenseManager lm = new LicenseManager(licenseParam);
        lm.install(new File(fileName));
        ActionMessages messages = new ActionMessages();
        ActionMessage msg = new ActionMessage("install.ok");
        messages.add("message", msg);

        saveMessages(request, messages);
        return mapping.findForward(SUCCESS);
    }
}
