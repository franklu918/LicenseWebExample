<%-- 
    Document   : login.jsp
    Created on : Feb 14, 2011, 9:35:39 PM
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
        <title>Login Page</title>
    </head>
    <body>
        <html:messages id="msg" message="true">
            <bean:write name="msg"/><br>
        </html:messages>
        <html:form action="/login.do">
            <table>
                <tr>
                    <td><label>User name:</label></td>
                    <td><html:text property="userName" value="" /></td>
                </tr>
                <tr>
                    <td><label>Password:</label></td>
                    <td><html:password property="password" value=""/></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><html:submit/></td>
                </tr>
            </table>
            </html:form>
    </body>
</html>
