/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujay;

import com.sujay.licensegeneration.CipherParamImpl;
import com.sujay.licensegeneration.KeyStoreParamImpl;
import com.sujay.licensegeneration.LicenseParamImpl;
import de.schlichtherle.license.CipherParam;
import de.schlichtherle.license.KeyStoreParam;
import de.schlichtherle.license.LicenseParam;

/**
 *
 * @author sujay
 */
public final class LicenseParamFactory {

    final static String SUBJECT = "License Generation";

    public static LicenseParam getLicenseParam() {
        KeyStoreParam keyStoreParam = new KeyStoreParamImpl("publicKeys.store", "publickey", "storepass@12", null);
        CipherParam cipherParam = new CipherParamImpl("keypass@12");
        LicenseParam licenseParam = new LicenseParamImpl(SUBJECT, keyStoreParam, cipherParam);
        return licenseParam;
    }
}
