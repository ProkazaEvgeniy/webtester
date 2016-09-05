<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div>You pass Test</div>
<div class="row">
	<div class="col-md-12">
		<form action="/student/nextQuestion" method="get">
		<input type="hidden" name="idQuestion" value="13">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>Question Name</th>
						<th>Answer Variant</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td><c:out value="${test.question.name }"></c:out></td>
						<td><c:forEach var="a" items="${test.answer}">${a.name}<div class="checkbox"><label> <input type="checkbox" name="varAnswer" value="yes">Click here</label></div><br>
							</c:forEach>
						</td>
					</tr>
				</tbody>
			</table>
			<div class="text-center">
				<a href="/student/home" class="btn btn-primary"><div class="glyphicon glyphicon-chevron-left"></div> Back to Pass Test</a>
				<button type="submit" class="btn btn-primary">Next Question <div class="glyphicon glyphicon-chevron-right"></div></button>
			</div>
		</form>
	</div>
</div>