<%-- 
    Document   : notes.jsp
    Created on : Mar 2, 2020, 2:48:21 PM
    Author     : 810783
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Notes!</h1>
        <form method="POST">
            <input type="hidden" name="action" value="edit"/>
            <table>
                <tr>
                    <td>Date Created</td>
                    <td>Title</td>
                </tr>
                <c:forEach var="oneNote" items="${noteList}" varStatus="status">
                        <tr>
                            <td>${oneItem.dateCreated}</td>
                            <td>${oneItem.title}</td>
                            <td><input type="submit" value="${status.index}" name="radioButton"/></td>
                        </tr>
                </c:forEach>
            </table>
        </form><br>
        <form method="POST" id="form2">
            <input type="hidden" name="action" value="add"/>
            <h2>${action} Note</h2>
            <input type="text" placeholder="Title" name="inputTitle"/><br>
            <textarea rows="7" cols="30" form="form2" name="inputContents"></textarea>
            <input type="submit" value="Add"/>
        </form>
    </body>
</html>
