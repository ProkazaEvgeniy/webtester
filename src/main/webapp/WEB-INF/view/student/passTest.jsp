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
			
					<tr>
						<td>1</td>
						<td><c:forEach var="q" items="${test.question}">${q.name}</c:forEach></td>
						<td><c:forEach var="a" items="${test.answer}">${a.name}<br>
								
									<div class="btn-group">
										<a href="/student/optionAnswer?id=${a.id}" type="button" class="btn btn-primary">Option</a>
									</div><br>
								
							</c:forEach>
						</td>
						
					</tr>
			
			</tbody>
		</table>
	</div>
</div>