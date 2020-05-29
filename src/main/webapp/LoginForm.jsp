<%--
  Created by IntelliJ IDEA.
  User: Unix
  Date: 28.04.2020
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</head>
<body>
<jsp:include page="header.jsp" />
<main>
    <div style="margin-top: 200px; margin-left: 450px">
        <%
            //демонстрирую вывод ошибки Error.jsp
            //int x =0;
            //int m = 8/0;
            if(request.getAttribute("code2") != null) {
                String spam = request.getAttribute("code2").toString();
                if (spam == "1") {
                    out.println("<h2 style= 'color:red'>there is no such user</h2>");
                }
            }
        %>
        <form action="LoginServlet" method="post">
            Login:<br>
            <input type="text" size="5" name="login"><br>
            Password:<br>
            <input type="text" size="5" name="password"><br>
            <input type="submit" value="Login">
        </form>
    </div>
</main>
<jsp:include page="footer.jsp" />
</body>
</html>
