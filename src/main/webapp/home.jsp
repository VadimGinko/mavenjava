
<%--
  Created by IntelliJ IDEA.
  User: Unix
  Date: 30.04.2020
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="my.Newspaper" %>
<%@ page import="my.Connect" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    ArrayList<Newspaper> q = Connect.take();

    out.println("<table style='border-spacing: 0 10px;\n" +
            "font-family: 'Open Sans', sans-serif;\n" +
            "font-weight: bold;'>");
    for(Newspaper w:q) {
        out.println("<tr>");
        out.println("<td style='vertical-align: middle;\n" +
                "padding: 10px;\n" +
                "font-size: 14px;\n" +
                "text-align: center;\n" +
                "border-top: 2px solid #56433D;\n" +
                "border-left: 2px solid #56433D;\n" +
                "border-bottom: 2px solid #56433D;\n" +
                "border-right: 2px solid #56433D;'>" + w.NewspaperName + "</td>");
        out.println("<td style='vertical-align: middle;\n" +
                "padding: 10px;\n" +
                "font-size: 14px;\n" +
                "text-align: center;\n" +
                "border-top: 2px solid #56433D;\n" +
                "border-bottom: 2px solid #56433D;\n" +
                "border-right: 2px solid #56433D;'>"+ w.NewspaperType + "</td>");

        out.println("</tr>");
    }
    out.println("</table>");
%>
<form action="AddServlet" method="post">
    Add Name: <input type="text" name="addname" />
        Type: <input type="text" name="addtype" />
    <input type="submit" value="Submit" />
</form>
<%--<form action="postuser.jsp">--%>
<%--    Delete by Name: <input name="deletename" />--%>
<%--    <input type="submit" value="Submit" />--%>
<%--</form>--%>
</body>
</html>
