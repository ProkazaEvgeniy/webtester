<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<img src="\static\images\foto.jpeg" alt="avatar" class="img-circle">



<div class="row">
	<div class="col-md-12">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Role</th>
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
						<td> <c:forEach var="roleAccount" items="${account.listRole}">
						<c:if test="${roleAccount.idRole == 1}">Admin</c:if>
						<c:if test="${roleAccount.idRole == 2}">Advance Tutor</c:if>
						<c:if test="${roleAccount.idRole == 3}">Tutor</c:if>
						<c:if test="${roleAccount.idRole == 4}">Student</c:if><br></c:forEach> </td>
						<td>
							<div class="btn-group">
								<a href="/admin/editAccount?id=${account.id}" type="button" class="btn btn-primary"><div class="glyphicon glyphicon-pencil"></div> Edit Account</a> 
								<a href="/admin/del?id=${account.id}" type="button" class="btn btn-danger"><div class="glyphicon glyphicon-remove"></div> Delete Account</a> 
								<a href="/admin/establishRole?id=${account.id}" type="button" class="btn btn-default"><div class="glyphicon glyphicon-eye-open"></div> Establish Role</a>
								<a href="/admin/deleteRole?id=${account.id}" type="button" class="btn btn-warning"><div class="glyphicon glyphicon-eye-close"></div> Delete Role</a> 
								<a onclick="hello()" type="button" class="btn btn-success"><div class="glyphicon glyphicon-expand"></div> <div class="glyphicon glyphicon-unchecked"></div> Enable</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="text-center">
			<a href="/admin/addAccount" class="btn btn-primary"><div class="glyphicon glyphicon-plus"></div> Add account</a>
		</div>

	</div>

</div>