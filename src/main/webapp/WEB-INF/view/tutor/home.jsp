<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<div>tutor</div>


<div class="row">
	<div class="col-md-12">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>Id Account</th>
					<th>Test Name</th>
					<th>Description</th>
					<th>Duration per Question</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fn:length(list) == 0 }">
					<tr>
						<td colspan="5">Empty list</td>
					</tr>
				</c:if>

				<c:forEach var="test" items="${list }">
					<tr>
						<td>${test.id}</td>
						<td>${test.idAccount}</td>
						<td>${test.name}</td>
						<td>${test.description}</td>
						<td>${test.durationPerQuestion}</td>
						<td>
							<div class="btn-group" >
								<a href="/tutor/editTest?id=${test.id}" type="button" class="btn btn-primary">Edit</a> 
								<a href="/tutor/del?id=${test.id}" type="button" class="btn btn-danger">Delete</a> 
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="text-center">
			<a href="/tutor/addTest" class="btn btn-primary">Add test</a>
		</div>
	</div>
</div>
