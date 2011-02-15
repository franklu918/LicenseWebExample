/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujay;

import de.schlichtherle.license.LicenseManager;
import de.schlichtherle.license.LicenseParam;
import de.schlichtherle.license.NoLicenseInstalledException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.MessageResources;

/**
 *
 * @author sujay
 */
public class UploadLicenseAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String LICENSE_LOCATION = "license.location";

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
        FileOutputStream fos = null;
        try {
            LicenseUploadForm licenseForm = (LicenseUploadForm) form;
            FormFile licenseFile = licenseForm.getFormFile();
            MessageResources resources = getResources(request);
            String licenseLocation = resources.getMessage(LICENSE_LOCATION);
            String fileName = licenseFile.getFileName();
            String absoluteFileName = licenseLocation + File.separatorChar + fileName;
            File file = new File(absoluteFileName);
            fos = new FileOutputStream(file);
            fos.write(licenseFile.getFileData());
            LicenseParam licenseParam = LicenseParamFactory.getLicenseParam();
            LicenseManager lm = new LicenseManager(licenseParam);            
            lm.install(file);
            ActionMessages messages = new ActionMessages();
            ActionMessage msg = new ActionMessage("install.ok");
            messages.add("message", msg);
            saveMessages(request, messages);
        } finally {
            fos.close();
        }
        return mapping.findForward(SUCCESS);
    }
}
