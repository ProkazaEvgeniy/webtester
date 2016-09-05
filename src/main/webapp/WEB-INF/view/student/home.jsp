<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div>student</div>
<div class="row">
	<div class="col-md-12">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>Test Name</th>
					<th>Description</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fn:length(list) == 0 }">
					<tr>
						<td colspan="5">Empty list</td>
					</tr>
				</c:if>
				<c:forEach var="test" items="${list }" varStatus="status">
					<tr>
						<td>${status.index+1}</td>
						<td>${test.name}</td>
						<td>${test.description}</td>
						<td>
							<div class="btn-group">
								<a href="/student/passTest?id=${test.id}" type="button" class="btn btn-primary">Pass the Test</a> 
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>