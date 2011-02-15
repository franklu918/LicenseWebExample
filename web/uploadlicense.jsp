<%-- 
    Document   : uploadlicense
    Created on : Feb 15, 2011, 9:46:15 AM
    Author     : sujay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload License</title>
    </head>
    <body>
        <html:form enctype="multipart/form-data" action="/uploadLicense.do">
             <table>
                <tr>                    
                    <td><label>User name:</label></td>
                    <td><html:file property="formFile"/></td>
                <tr>
                <tr>
                    <td colspan="2"><html:submit value="Upload"/></td>
                </tr>
             </table>
        </html:form>
    </body>
</html>
