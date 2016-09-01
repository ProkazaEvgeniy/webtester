<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<div>advance</div>


<div class="row">
	<div class="col-md-12">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>Question Name</th>
					<th>Answer Name</th>
					<th>Correct</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fn:length(list) == 0 }">
					<tr>
						<td colspan="5">Empty list</td>
					</tr>
				</c:if>

				<c:forEach var="answer" items="${list }">
					<tr>
						<td>${answer.id}</td>
						<td><c:out value="${answer.question.name}"></c:out></td>
						<td>${answer.name}</td>
						<td>${answer.correct}</td>
						<td>
							<div class="btn-group" >
								<a href="/advance/editAnswer?id=${answer.id}" type="button" class="btn btn-primary">Edit</a> 
								<a href="/advance/delAnswer?id=${answer.id}" type="button" class="btn btn-danger">Delete</a> 
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="text-center">
			<a href="/advance/addAnswer" class="btn btn-primary">Add Answer</a>
		</div>
	</div>
</div>