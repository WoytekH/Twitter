<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import=" java.util.* " %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<H1>
    ----------------------------------FOLLOWED-------------------------------------------------
</H1>
<div>
    <c:forEach items="${followedUsers}" var ="user">
        <strong>${user.login}</strong><br>
        <strong>${user.password}</strong><br>
        <strong>${user.email}</strong><br>
        <strong><fmt:formatDate value="${user.dateOfRegistration}" pattern="yyyy-MM-dd HH-mm"/>  </strong><br>
    </c:forEach>
</div>
<H1>
    ----------------------------------NOT FOLLOWED-------------------------------------------------
</H1>
<div>
    <c:forEach items="${notFollowedUsers}" var ="user">
        <strong>${user.login}</strong><br>
        <strong>${user.password}</strong><br>
        <strong>${user.email}</strong><br>
        <strong><fmt:formatDate value="${user.dateOfRegistration}" pattern="yyyy-MM-dd HH-mm"/>  </strong><br>
    </c:forEach>
</div>
</body>
</html>





