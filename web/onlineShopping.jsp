<%-- 
    Document   : onlineShopping
    Created on : May 4, 2018, 12:46:17 AM
    Author     : viquy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Smart Store</title>
    </head>
    <body>
        <h1>Welcome to SMart Store !</h1>
        <s:form action="addToCart">
            <s:select name="item" list="itemsList" label="Choose Items"/>
            <s:submit value="Add Selected Item to Your Cart"/>
        </s:form> <br/>
        <s:a href="viewCart">View Your Cart</s:a>
    </body>
</html>
