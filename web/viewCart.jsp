<%-- 
    Document   : viewCart
    Created on : May 4, 2018, 12:46:28 AM
    Author     : viquy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
    </head>
    <body>
        <h1>Your Cart's Items include!</h1>
        <s:if test="%{#session.CART != null}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Name.</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <s:form action="removeCart" theme="simple">
                        <s:iterator value="%{#session.CART.items}" status="counter">
                            <tr>
                                <td>
                                    <s:property value="%{#counter.count}"/>
                                </td>
                                <td>
                                    <s:property value="key.productName"/>
                                </td>
                                <td>
                                    <s:property value="value"/>
                                </td>
                                <td>
                                    <s:property value="key.price"/>
                                </td>
                                <td>
                                    <s:checkbox name="selectedItem" fieldValue="%{key.productId}"/>
                                </td>
                            </tr>
                        </s:iterator>         
                        <tr>
                            <td colspan="4">
                                <s:a href="addMore">Add more items to your cart</s:a>
                            </td>
                            <td>
                                <s:submit value="Remove Selected Items"/>
                            </td>
                        </tr>
                    </s:form>
                </tbody>
            </table>
        </s:if>
        <s:if test="%{#session.CART == null}">
            <h2>No cart is existed!</h2>
        </s:if>
    </body>
</html>
