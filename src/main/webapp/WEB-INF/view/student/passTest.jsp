<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<div>You pass Test</div>


<div class="row">
	<div class="col-md-12">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>Question Name</th>
					<th>Answer Variant</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fn:length(test) == 0 }">
					<tr>
						<td colspan="5">Empty test</td>
					</tr>
				</c:if>

				<c:forEach var="answer" items="${test}" varStatus="status">
					<tr>
						<td>${status.index+1}</td>
						<td><c:forEach var="q" items="${test.question}">${q.name}</c:forEach></td>
						<td><c:forEach var="a" items="${test.answer}">${a.name}</c:forEach></td>
						<td>
							<div class="btn-group" >
								<a href="/advance/editAnswer?id=#" type="button" class="btn btn-primary">Edit</a> 
								<a href="/advance/delAnswer?id=#" type="button" class="btn btn-danger">Delete</a> 
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>