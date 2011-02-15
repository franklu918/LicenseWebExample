/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sujay;

import org.apache.struts.upload.FormFile;

/**
 *
 * @author sujay
 */
public class LicenseUploadForm extends org.apache.struts.action.ActionForm {
    
    private FormFile formFile;

    /**
     * @return the formFile
     */
    public FormFile getFormFile() {
        return formFile;
    }

    /**
     * @param formFile the formFile to set
     */
    public void setFormFile(FormFile formFile) {
        this.formFile = formFile;
    }
}
