<%--
  Created by IntelliJ IDEA.
  User: Unix
  Date: 08.05.2020
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"  %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="my" uri="/WEB-INF/Tag.tld" %>

<%@ page import="java.lang.Math" %>
<html>
<head>
</head>
<body>
<h1>------------EL--------------------------</h1>
<h1>Task12</h1>
<%
    pageContext.setAttribute("spam","Vadim");
%>
<h3>q: ${spam}</h3>
<form action="Task12Info" method="post">

    Name: <input name="name" />
    <br><br>
    Main Phone: <input name="phone" />
    <br></br>
    Additional Phone: <input name="phone" />
    <br></br>
    <input type="submit" value="Submit" />
</form>
    <h1>------------core--------------------------</h1>
    <c:out  value="Выведено с помощью тега:out"></c:out>
    <br>
    <c:set var="surname" value="Ginko" scope="page"></c:set>
    <br>
    <c:out value="переменная surname значение: ${surname}"></c:out>
    <br>
    <c:if test="${2>0}">
        Условие верно
    </c:if>
    <c:remove var="surname" scope="page"></c:remove>
    <br>
    <c:out value="переменная surname значение после remove: ${surname}"></c:out>

    <c:set var="rand" value="${Math.random()*10}"></c:set>
    <br>
    <c:choose>
        <c:when test="${rand < 5}">
            <c:out value="число меньше 5"></c:out>
        </c:when>
        <c:when test="${rand > 5}">
            <c:out value="число больше 5"></c:out>
        </c:when>
    </c:choose>
    <h1>------------ftm--------------------------</h1>
    <c:set var="accountBalance" value="12345.6789" />
    <p>
        formatNumber (type='currency'):
        <strong>
            <fmt:formatNumber value="${accountBalance}" type="currency"/>
        </strong>
    </p>
    <p>
        formatNumber (type='number', maxIntegerDigits= '3'):
        <strong>
            <fmt:formatNumber type="number" maxIntegerDigits="3" value="${accountBalance}" />
        </strong>
    </p>
    <p>
        formatNumber (type='number', maxFractionDigits= '3'):
        <strong>
            <fmt:formatNumber type="number" maxFractionDigits="3" value="${accountBalance}" />
        </strong>
    </p>
    <p>
        formatNumber (type='number', groupingUsed= 'false'):
        <strong>
            <fmt:formatNumber type="number" groupingUsed="false" value="${accountBalance}" />
        </strong>
    </p>
    <p>
        formatNumber (type='percent', maxIntegerDigits= '3'):
        <strong>
            <fmt:formatNumber type="percent" maxIntegerDigits="3" value="${accountBalance}" />
        </strong>
    </p>
    <p>
        formatNumber (type='percent', maxIntegerDigits= '10'):
        <strong>
            <fmt:formatNumber type="percent" minFractionDigits="10" value="${accountBalance}" />
        </strong>
    </p>
    <p>
        formatNumber (type='number', pattern= '###.###E0'):
        <strong>
            <fmt:formatNumber type="number" pattern="###.###E0" value="${accountBalance}" />
        </strong>
    </p>
    <p>
        Account Balance in USA (fmt:setLocale value='en_US'):
        <br/>
        formatNumber (type='currency'):
        <fmt:setLocale value="en_US"/>
        <strong>
            <fmt:formatNumber value="${accountBalance}" type="currency"/>
        </strong>
    <p>
    <c:set var="now" value="<%=new java.util.Date()%>" />
    <p>
        Time (fmt:formatDate type="time"):
        <strong>
            <fmt:formatDate type="time" value="${now}" />
        </strong>
    </p>
    <p>
        Date (fmt:formatDate type="date"):
        <strong>
            <fmt:formatDate type="date" value="${now}" />
        </strong>
    </p>
    <p>
        Date, Time (fmt:formatDate type="both"):
        <strong>
            <fmt:formatDate type="both" value="${now}" />
        </strong>
    </p>
    <p>
        <fmt:setLocale value="en" scope="session"/>
        <fmt:setBundle basename="resources.package" var="rb"/>
            <fmt:message key="label.title" bundle="${ rb }" />
<h1>------------sql--------------------------</h1>

<sql:query var="result" sql="SELECT * FROM account"
           dataSource="jdbc:mysql://localhost:3306/servlet?autoReconnect=true&useSSL=false, com.mysql.jdbc.Driver, root, 6788393vadim">
</sql:query>
<c:forEach var = "row" items = "${result.rows}">
    <tr>
        <td> <c:out value = "${row.name}"/></td>
    </tr>
</c:forEach>
<h1>------------xml--------------------------</h1>

<c:set var="vegetable">
<vegetables>
    <vegetable>
        <name>onion</name>
        <price>40/kg</price>
    </vegetable>
    <vegetable>
        <name>Potato</name>
        <price>30/kg</price>
    </vegetable>
    <vegetable>
        <name>Tomato</name>
        <price>90/kg</price>
    </vegetable>
</vegetables>
</c:set>
<x:parse xml="${vegetable}" var="output"/>
<b>Name of the vegetable is</b>:
<x:out select="$output" /><br>



<h1>------------functions--------------------------</h1>
<c:out value="${fn:toUpperCase('vadimmmmm')}"></c:out>
<h1>------------custom tags--------------------------</h1>

<my:TagTable myCol="2" myRow="3"/>

<form action="LoginServlet" method="post">
    <c:out value="Login:" /><br>
    <input type="text" size="5" name="login"><br>
    <c:out value="Password:" /><br>
    <input type="text" size="5" name="password"><br>
    <my:LoginTag value="login"/>
<br>
<my:TextTag name = "NAME"/>
</html>
