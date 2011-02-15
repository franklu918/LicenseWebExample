<%-- 
    Document   : error
    Created on : Feb 14, 2011, 10:10:21 PM
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
        <title>Error Page</title>
    </head>
    <body>
        <h1>An Error Occurred in Application</h1>
        <logic:present name="installFailed" scope="request">
            <div  style="color: red">
                <%=request.getAttribute("installFailed")%>
            </div>
        </logic:present>
    </body>
</html>
