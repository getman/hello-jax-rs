<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="ru.aparfenov.restful.pocket.model.PocketElement" %>
<%--<%@ page import="getman.ejb3.jpa.relations.AuthorEntity" %>
<%@ page import="getman.ejb3.jpa.relations.BookReviewEntity" %>
<%@ page import="getman.ejb3.jpa.relations.BookSpoiler" %>
<%@ page import="getman.ejb3.jpa.relations.ISBN" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pocket</title>
</head>
<body>
Pocket list
<% Object pocketList = request.getAttribute("pocket-list");%>
<% if ((pocketList != null) && (!((List<PocketElement>) pocketList).isEmpty())) { %>
<table border="3">
    <tr>
        <td>title</td>
        <td>data</td>
    </tr>
    <% for (PocketElement nextBook : (List<PocketElement>) pocketList) { %>
    <tr>
        <%--id--%>
        <td><%= nextBook.getDataTitle() %></td>
        <%--title--%>
        <td><%= nextBook.getData() %></td>
        <%--book author(s)--%>
    </tr>
    <% } %>
</table>
<% } else { %>
no pockets
<% } %>
<form method="POST" action="pocket">
    <p>
        <label for="item">Add pocket, title:</label>
        <input id="new-pocket-title" type="text" name="new-pocket-title"/>

        <label for="item">data:</label>
        <input id="new-pocket-data" type="text" name="new-pocket-data"/>

        <input type="hidden" name="action" value="add"/>
        <input type="submit" value="add"/>
    </p>

</form>

</body>
</html>

