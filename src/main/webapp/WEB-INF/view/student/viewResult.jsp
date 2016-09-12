<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div>You Result Test</div>
<div class="row">
	<div class="col-md-12">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>Test Name</th>
						<th>Result (%)</th>
						<th>Created</th>
					</tr>
				</thead>
				<tbody>
				<c:if test="${fn:length(listResult) == 0 }">
					<tr>
						<td colspan="5">Empty list</td>
					</tr>
				</c:if>
				<c:forEach var="listResult" items="${listResult }" varStatus="status">
					<tr>
						<td>${status.index+1}</td>
						<td>${listResult.testName }</td>
						<td>${listResult.percent }</td>
						<td>${listResult.created }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<div class="text-center">
				<a href="/student/home" class="btn btn-primary"><div class="glyphicon glyphicon-chevron-left"></div> Back to Pass Test</a>
			</div>
	</div>
</div>