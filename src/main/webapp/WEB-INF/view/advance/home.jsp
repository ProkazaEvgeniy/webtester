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
					<th>Test Name</th>
					<th>Question Name</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fn:length(list) == 0 }">
					<tr>
						<td colspan="5">Empty list</td>
					</tr>
				</c:if>

				<c:forEach var="question" items="${list }">
					<tr>
						<td>${question.id}</td>
						<td><c:out value="${question.test.name}"></c:out></td>
						<td>${question.name}</td>
						<td>
							<div class="btn-group" >
								<a href="/advance/editQuestion?id=${question.id}" type="button" class="btn btn-primary">Edit</a> 
								<a href="/advance/del?id=${question.id}" type="button" class="btn btn-danger">Delete</a> 
								
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="text-center">
			<a href="/advance/addQuestion" class="btn btn-primary">Add Question</a>
			<a href="/advance/home-answer" class="btn btn-default">Show Answer</a>
			<a href="/tutor/home" class="btn btn-default">Show Test</a>
		</div>
	</div>
</div>