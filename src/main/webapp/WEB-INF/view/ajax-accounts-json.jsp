<%@ page contentType="application/json; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
[
<c:forEach var="account" items="${list }">
{
"id" : ${account.id},
"firstName" : "${account.firstName}",
"lastName" : "${account.lastName}",
"email" : "${account.email}"
}
</c:forEach>
]
