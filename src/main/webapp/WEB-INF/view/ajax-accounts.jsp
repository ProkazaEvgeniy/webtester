<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<img src="\static\images\foto.jpeg" alt="avatar" class="img-circle">



<div class="row">
	<div class="col-md-10">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fn:length(list) == 0 }">
					<tr>
						<td colspan="5">Empty list</td>
					</tr>
				</c:if>

				<c:forEach var="account" items="${list }">
					<tr>
						<td scope="row">${account.id}</td>
						<td class="name">${account.firstName}</td>
						<td>${account.lastName}</td>
						<td>${account.email}</td>
						<td>
							<div class="btn-group" role="group" aria-label="...">
								<a href="/admin/editAccount?id=${account.id}" type="button"
									class="btn btn-primary">Edit</a> <a href="/admin/del?id=5"
									type="button" class="btn btn-danger">Delete</a> <a
									onclick="hello()" type="button" class="btn btn-success">Enable</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="text-center">
			<a href="/admin/addAccount" class="btn btn-primary">Add account</a>
		</div>

	</div>

</div>